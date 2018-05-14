package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN630500Req;
import com.cdkj.loan.dto.req.XN630502Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ELoanOrderStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class LoanOrderAOImpl implements ILoanOrderAO {

    @Autowired
    private ILoanOrderBO loanOrderBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Override
    public String addLoanOrder(XN630500Req req) {
        LoanOrder data = new LoanOrder();
        data.setMobile(req.getMobile());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());
        data.setRealName(req.getRealName());

        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setCarCode(req.getCarCode());

        data.setCarPrice(StringValidater.toLong(req.getCarPrice()));
        data.setSfRate(StringValidater.toDouble(req.getSfRate()));
        data.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        data.setLoanBank(req.getLoanBank());
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));

        data.setPeriods(StringValidater.toInteger(req.getPeriods()));
        data.setBankRate(StringValidater.toDouble(req.getBankRate()));
        data.setLoanStartDatetime(DateUtil.strToDate(req.getLoanStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLoanEndDatetime(DateUtil.strToDate(req.getLoanEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFkDatetime(DateUtil.strToDate(req.getFkDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setFxDeposit(StringValidater.toLong(req.getFxDeposit()));
        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
        data.setFirstRepayDatetime(DateUtil.strToDate(
            req.getFirstRepayDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFirstRepayAmount(
            StringValidater.toLong(req.getFirstRepayAmount()));

        data.setMonthDatetime(
            StringValidater.toInteger(req.getMonthDatetime()));
        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setLyDeposit(StringValidater.toLong(req.getLyDeposit()));
        if (req.getIsSubmit().equals(EBoolean.NO.getCode())) {
            data.setStatus(ELoanOrderStatus.TO_SUBMIT.getCode());
        } else {
            data.setStatus(ELoanOrderStatus.TO_AUDIT.getCode());
        }
        data.setUpdater(req.getUpdater());

        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return loanOrderBO.saveLoanOrder(data);
    }

    @Override
    public int editLoanOrder(XN630502Req req) {
        LoanOrder data = loanOrderBO.getLoanOrder(req.getCode());
        if (ELoanOrderStatus.TO_AUDIT.getCode().equals(data.getStatus())
                || ELoanOrderStatus.AUDIT_PASS.getCode()
                    .equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该订单已提交或审核通过，不能修改！");
        }
        data.setMobile(req.getMobile());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());
        data.setRealName(req.getRealName());
        data.setBankCode(req.getBankCode());

        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setCarCode(req.getCarCode());
        data.setCarPrice(StringValidater.toLong(req.getCarPrice()));

        data.setSfRate(StringValidater.toDouble(req.getSfRate()));
        data.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        data.setLoanBank(req.getLoanBank());
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        data.setPeriods(StringValidater.toInteger(req.getPeriods()));

        data.setBankRate(StringValidater.toDouble(req.getBankRate()));
        data.setLoanStartDatetime(DateUtil.strToDate(req.getLoanStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLoanEndDatetime(DateUtil.strToDate(req.getLoanEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFkDatetime(DateUtil.strToDate(req.getFkDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFxDeposit(StringValidater.toLong(req.getFxDeposit()));

        data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
        data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
        data.setFirstRepayDatetime(DateUtil.strToDate(
            req.getFirstRepayDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFirstRepayAmount(
            StringValidater.toLong(req.getFirstRepayAmount()));
        data.setMonthDatetime(
            StringValidater.toInteger(req.getMonthDatetime()));

        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setLyDeposit(StringValidater.toLong(req.getLyDeposit()));
        if (req.getIsSubmit().equals(EBoolean.NO.getCode())) {
            data.setStatus(ELoanOrderStatus.TO_SUBMIT.getCode());
        } else {
            data.setStatus(ELoanOrderStatus.TO_AUDIT.getCode());
        }
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        data.setRemark(req.getRemark());
        return loanOrderBO.refreshLoanOrder(data);
    }

    /**
     * 1. 根据code查询车贷订单详情得到loadOrder 
     * 2. 判断订单状态是否是代审核
     * 3. 根据aprroveResult判断审核结果 0 订单状态不通过 1通过 
     * 4. 如果审核通过，用户代注册并实名认证，绑定用户银行卡，自动生成还款业务，自动生成还款计划
     * 5. 更新车贷订单状态
     */
    @Override
    @Transactional
    public void approveLoanOrder(String code, String approveResult,
            String approveUser, String approveNote) {

        // 根据code查询车贷订单详情得到loadOrder,判断订单状态是否是代审核
        LoanOrder loanOrder = loanOrderBO.checkCanAudit(code);

        if (approveResult.equals(EBoolean.NO.getCode())) {

            // 审核不通过
            loanOrderBO.approveFailed(loanOrder, approveUser, approveNote);

        } else {

            // 检查用户是否已经注册过
            String userId = userBO.getUserIdByMobile(loanOrder.getMobile());
            if (StringUtils.isBlank(userId)) {
                // 用户代注册并实名认证
                userId = userBO.doRegisterAndIdentify(loanOrder.getMobile(),
                    loanOrder.getIdKind(), loanOrder.getRealName(),
                    loanOrder.getIdNo());
            }

            // 绑定用户银行卡
            String bankcardCode = bankcardBO.bind(userId,
                loanOrder.getRealName(), loanOrder.getBankcardNumber(),
                loanOrder.getBankCode(), loanOrder.getBankName(),
                loanOrder.getSubbranch());

            // 自动生成还款业务
            RepayBiz repayBiz = repayBizBO
                .genereateNewCarLoanRepayBiz(loanOrder, userId, bankcardCode);

            // 自动生成还款计划
            repayPlanBO.genereateNewRapayPlan(repayBiz);

            // 审核通过
            String repayBizCode = repayBiz.getCode();
            loanOrderBO.approveSuccess(loanOrder, repayBizCode, userId,
                approveUser, approveNote);
        }

    }

    @Override
    public Paginable<LoanOrder> queryLoanOrderPage(int start, int limit,
            LoanOrder condition) {
        Paginable<LoanOrder> results = loanOrderBO.getPaginable(start, limit,
            condition);
        for (LoanOrder loanOrder : results.getList()) {
            loanOrder.setUser(userBO.getUser(loanOrder.getUserId()));
        }
        return results;
    }

    @Override
    public List<LoanOrder> queryLoanOrderList(LoanOrder condition) {
        return loanOrderBO.queryLoanOrderList(condition);
    }

    @Override
    public LoanOrder getLoanOrder(String code) {
        LoanOrder loanOrder = loanOrderBO.getLoanOrder(code);
        loanOrder.setUser(userBO.getUser(loanOrder.getUserId()));
        return loanOrder;
    }
}
