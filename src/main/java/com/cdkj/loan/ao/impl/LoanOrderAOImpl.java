package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanOrder;
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
        ;

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
        data.setMonthDatetime(DateUtil.strToDate(req.getMonthAmount(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setLyDeposit(StringValidater.toLong(req.getLyDeposit()));
        if (req.getIsSubmit().equals(EBoolean.NO.getCode())) {
            data.setStatus(ELoanOrderStatus.TO_SUBMIT.getCode());
        }
        data.setStatus(ELoanOrderStatus.TO_AUDIT.getCode());
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
        data.setMonthDatetime(DateUtil.strToDate(req.getMonthAmount(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setLyDeposit(StringValidater.toLong(req.getLyDeposit()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        data.setRemark(req.getRemark());
        return loanOrderBO.refreshLoanOrder(data);
    }

    @Override
    public int dropLoanOrder(String code) {
        if (!loanOrderBO.isLoanOrderExist(code)) {
            throw new BizException("xn0000", "车贷订单编号不存在");
        }
        return loanOrderBO.removeLoanOrder(code);
    }

    @Override
    public Paginable<LoanOrder> queryLoanOrderPage(int start, int limit,
            LoanOrder condition) {
        return loanOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<LoanOrder> queryLoanOrderList(LoanOrder condition) {
        return loanOrderBO.queryLoanOrderList(condition);
    }

    @Override
    public LoanOrder getLoanOrder(String code) {
        return loanOrderBO.getLoanOrder(code);
    }
}
