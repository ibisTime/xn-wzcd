package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IReplaceRepayApplyAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632320Req;
import com.cdkj.loan.enums.EReplaceRepayStatus;
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
    private IBankcardBO bankcardBO;

    @Override
    public String addReplaceRepayApply(XN632320Req req) {
        ReplaceRepayApply condition = new ReplaceRepayApply();
        condition.setBizCode(req.getBizCode());
        if (0 != replaceRepayApplyBO.getTotalCount(condition)) {
            throw new BizException("xn0000", "当前业务已申请代偿预算单，请勿重复申请！");
        }

        ReplaceRepayApply data = new ReplaceRepayApply();
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setBizCode(req.getBizCode());

        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getBizCode());
        Bankcard bankcard = bankcardBO.getBankcardByUserId(repayPlan
            .getUserId());
        data.setReceiptBank(bankcard.getBankName());
        data.setReceiptAccount(bankcard.getBankcardNumber());
        data.setReceiptRealName(bankcard.getRealName());

        data.setIsUrgent(req.getIsUrgent());
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        data.setApplyDatetime(new Date());
        data.setStatus(EReplaceRepayStatus.TO_APPROVE.getCode());
        data.setType(EReplaceRepayType.MONTHLY_PAYMENT.getCode());
        return replaceRepayApplyBO.saveReplaceRepayApply(data);
    }

    @Override
    public void refreshFinanceManageApprove(String code, String approveResult,
            String updater, String remark) {
        ReplaceRepayApply data = replaceRepayApplyBO.getReplaceRepayApply(code);
        if (!EReplaceRepayStatus.TO_APPROVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "预算单不在财务经理审核状态！");
        }

        replaceRepayApplyBO.refreshFinanceManageApprove(code, approveResult,
            updater, remark);
    }

    @Override
    public void refreshMakeDocument(String code, String updater) {
        ReplaceRepayApply data = replaceRepayApplyBO.getReplaceRepayApply(code);
        if (!EReplaceRepayStatus.APPROVED_YES.getCode()
            .equals(data.getStatus())) {
            throw new BizException("xn0000", "预算单不在制单状态！");
        }

        replaceRepayApplyBO.refreshMakeDocument(code, updater);
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
    }

}
