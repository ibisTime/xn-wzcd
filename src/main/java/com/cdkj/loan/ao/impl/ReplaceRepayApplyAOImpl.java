package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IReplaceRepayApplyAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632320Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EReplaceRepayApplyNode;
import com.cdkj.loan.enums.EReplaceRepayType;
import com.cdkj.loan.exception.BizException;

/**
 * 代偿预算单
 * @author: silver 
 * @since: 2018年6月14日 下午10:18:17 
 * @history:
 */
@Service
public class ReplaceRepayApplyAOImpl implements IReplaceRepayApplyAO {

    @Autowired
    private IReplaceRepayApplyBO replaceRepayApplyBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ISYSDictBO sysDictBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public String addReplaceRepayApply(XN632320Req req) {
        if (EReplaceRepayType.REMAIN_LOAN.getCode().equals(req.getType())) {// 代偿性质是剩余贷款金额一笔还款业务只能申请一次代偿
            ReplaceRepayApply condition = new ReplaceRepayApply();
            condition.setBizCode(req.getBizCode());
            condition.setType(EReplaceRepayType.REMAIN_LOAN.getCode());
            if (replaceRepayApplyBO.getTotalCount(condition) > 0) {
                throw new BizException("xn0000",
                    "当前业务已申请代偿预算单(代偿剩余贷款金额类型)，请勿重复申请！");
            }
        }
        ReplaceRepayApply data = new ReplaceRepayApply();
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setBizCode(req.getBizCode());// 还款业务编号
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getBizCode());
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        data.setReceiptBank(bankcard.getBankName());
        data.setReceiptAccount(bankcard.getBankcardNumber());
        data.setReceiptRealName(bankcard.getRealName());
        data.setIsUrgent(req.getIsUrgent());
        data.setApplyUser(req.getApplyUser());// 取的是当前操作人 不是客户
        data.setApplyNote(req.getApplyNote());
        data.setApplyDatetime(new Date());
        data.setCurNodeCode(EReplaceRepayApplyNode.FINANCE_APPROVE.getCode());
        data.setType(req.getType());
        String code = replaceRepayApplyBO.saveReplaceRepayApply(data);
        sysBizLogBO.recordCurrentSYSBizLog(data.getBizCode(),
            EBizLogType.REPLACE_REPAY_APPLY, code,
            EReplaceRepayApplyNode.APPLY.getCode(), req.getApplyNote(),
            req.getApplyUser());
        sysBizLogBO.saveSYSBizLog(data.getBizCode(),
            EBizLogType.REPLACE_REPAY_APPLY, code,
            EReplaceRepayApplyNode.FINANCE_APPROVE.getCode());
        return code;
    }

    @Override
    public void refreshFinanceManageApprove(String code, String approveResult,
            String approveNote, String updater, String remark) {
        ReplaceRepayApply data = replaceRepayApplyBO.getReplaceRepayApply(code);
        String preCurNodeCode = data.getCurNodeCode();
        if (!EReplaceRepayApplyNode.FINANCE_APPROVE.getCode().equals(
            preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "预算单不在财务经理审核状态！");
        }

        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        replaceRepayApplyBO.refreshFinanceManageApprove(code, approveResult,
            updater, note);
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getBizCode(),
            EBizLogType.REPLACE_REPAY_APPLY, data.getCode(), preCurNodeCode,
            data.getCurNodeCode(), approveNote, updater);
    }

    @Override
    public void refreshMakeDocument(String code, String updater) {
        ReplaceRepayApply data = replaceRepayApplyBO.getReplaceRepayApply(code);
        String preCurNodeCode = data.getCurNodeCode();
        if (!EReplaceRepayApplyNode.MAKE_BILL.getCode().equals(preCurNodeCode)) {
            throw new BizException("xn0000", "预算单不在制单状态！");
        }
        replaceRepayApplyBO.refreshMakeDocument(code, updater);
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPLACE_REPAY_APPLY,
            data.getCode(), preCurNodeCode, null, updater);
    }

    @Override
    public Paginable<ReplaceRepayApply> queryReplaceRepayApplyPage(int start,
            int limit, ReplaceRepayApply condition) {
        Paginable<ReplaceRepayApply> page = replaceRepayApplyBO.getPaginable(
            start, limit, condition);
        List<ReplaceRepayApply> list = page.getList();
        for (ReplaceRepayApply replaceRepayApply : list) {
            init(replaceRepayApply);
        }
        return page;

    }

    @Override
    public List<ReplaceRepayApply> queryReplaceRepayApplyList(
            ReplaceRepayApply condition) {
        List<ReplaceRepayApply> list = replaceRepayApplyBO
            .queryReplaceRepayApplyList(condition);
        for (ReplaceRepayApply replaceRepayApply : list) {
            init(replaceRepayApply);
        }
        return list;
    }

    @Override
    public ReplaceRepayApply getReplaceRepayApply(String code) {
        ReplaceRepayApply replaceRepayApply = replaceRepayApplyBO
            .getReplaceRepayApply(code);
        init(replaceRepayApply);
        return replaceRepayApply;
    }

    private void init(ReplaceRepayApply replaceRepayApply) {
        if (StringUtils.isNotBlank(replaceRepayApply.getApplyUser())) {
            SYSUser applyUser = sysUserBO.getUser(replaceRepayApply
                .getApplyUser());
            replaceRepayApply.setApplyUserName(applyUser.getRealName());
        }

        if (StringUtils.isNotBlank(replaceRepayApply.getUpdater())) {
            SYSUser updaterUser = sysUserBO.getUser(replaceRepayApply
                .getUpdater());
            replaceRepayApply.setUpdaterName(updaterUser.getRealName());
        }
        if (StringUtils.isNotBlank(replaceRepayApply.getBizCode())) {
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrderByRepayBizCode(replaceRepayApply.getBizCode());
            replaceRepayApply.setBudgetOrder(budgetOrder);
        }
    }

}
