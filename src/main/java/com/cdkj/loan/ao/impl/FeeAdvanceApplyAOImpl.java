package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.bo.IFeeAdvanceApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.FeeAdvanceApply;
import com.cdkj.loan.dto.req.XN632670Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EFeeAdvanceApplyStatus;
import com.cdkj.loan.enums.EFeeAdvanceApplyType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Service
public class FeeAdvanceApplyAOImpl implements IFeeAdvanceApplyAO {

    @Autowired
    private IFeeAdvanceApplyBO feeAdvanceApplyBO;

    @Override
    public String addFeeAdvanceApply(XN632670Req req) {
        FeeAdvanceApply data = new FeeAdvanceApply();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.FEE_ADVANCE_APPLY.getCode());
        data.setType(req.getType());
        if (EFeeAdvanceApplyType.BUY_ASSERT.getCode().equals(req.getType())
                || EFeeAdvanceApplyType.BUY_OFFICE.getCode().equals(
                    req.getType())) {
            if (StringUtils.isBlank(req.getRefAssertCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请选择关联资产审批列表");
            }
        }
        data.setRefAssertCode(req.getRefAssertCode());
        if (EFeeAdvanceApplyType.DH_RECEIPT.getCode().equals(req.getType())) {
            if (StringUtils.isBlank(req.getRefAssertCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "贷后催收费用请选择关联车贷业务列表");
            }
        }
        data.setRefBudgetOrderCode(req.getRefBudgetOrderCode());
        data.setAmount(StringValidater.toLong(req.getAmount()));

        data.setSubbranch(req.getSubbranch());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setAccountName(req.getAccountName());
        String status = EFeeAdvanceApplyStatus.TO_APPROVE.getCode();
        if (StringUtils.isNotBlank(data.getRefAssertCode())) {
            status = EFeeAdvanceApplyStatus.APPROVE_YES.getCode();// 直接跳到待财务审核
        }

        data.setStatus(status);
        data.setApplyUser(req.getApplyUser());

        data.setApplyDatetime(new Date());
        data.setApplyNote(req.getApplyNote());
        feeAdvanceApplyBO.saveFeeAdvanceApply(data);
        return code;
    }

    @Override
    public void approveApply(String code, String approveResult, String updater,
            String remark) {
        FeeAdvanceApply data = getFeeAdvanceApply(code);
        if (!EFeeAdvanceApplyStatus.TO_APPROVE.getCode().equals(
            data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前费用预支申请单状态不是待审核状态");
        }
        String status = EFeeAdvanceApplyStatus.APPROVE_NO.getCode();
        if (EBoolean.YES.getCode().equals(approveResult)) {
            status = EFeeAdvanceApplyStatus.APPROVE_YES.getCode();
        }
        feeAdvanceApplyBO.refreshFeeAdvanceApplyApprove(data, status, updater,
            remark);
    }

    @Override
    public void financeApproveApply(String code, String approveResult,
            String updater, String remark) {
        FeeAdvanceApply data = getFeeAdvanceApply(code);
        if (!EFeeAdvanceApplyStatus.APPROVE_YES.getCode().equals(
            data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前费用预支申请单状态不是待财务审核状态");
        }

        String status = EFeeAdvanceApplyStatus.FINANCE_APPROVE_NO.getCode();
        if (EBoolean.YES.getCode().equals(approveResult)) {
            status = EFeeAdvanceApplyStatus.FINANCE_APPROVE_YES.getCode();
        }
        feeAdvanceApplyBO.refreshFeeAdvanceApplyFinanceApprove(data, status,
            updater, remark);
    }

    @Override
    public void sureFk(String code, String payDatetime, String payBank,
            String payBankcard, String payPdf, String updater) {
        FeeAdvanceApply data = getFeeAdvanceApply(code);
        if (!EFeeAdvanceApplyStatus.FINANCE_APPROVE_YES.getCode().equals(
            data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前费用预支申请单状态不是待确认放款状态");
        }

        data.setPayDatetime(DateUtil.strToDate(payDatetime,
            DateUtil.DATA_TIME_PATTERN_1));
        data.setPayBank(payBank);
        data.setPayBankcard(payBankcard);
        data.setPayPdf(payPdf);
        data.setStatus(EFeeAdvanceApplyStatus.SURE_FK.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        feeAdvanceApplyBO.sureFk(data);
    }

    @Override
    public Paginable<FeeAdvanceApply> queryFeeAdvanceApplyPage(int start,
            int limit, FeeAdvanceApply condition) {
        return feeAdvanceApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FeeAdvanceApply> queryFeeAdvanceApplyList(
            FeeAdvanceApply condition) {
        return feeAdvanceApplyBO.queryFeeAdvanceApplyList(condition);
    }

    @Override
    public FeeAdvanceApply getFeeAdvanceApply(String code) {
        return feeAdvanceApplyBO.getFeeAdvanceApply(code);
    }
}
