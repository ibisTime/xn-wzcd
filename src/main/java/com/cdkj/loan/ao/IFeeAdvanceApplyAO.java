package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.FeeAdvanceApply;
import com.cdkj.loan.dto.req.XN632670Req;

@Component
public interface IFeeAdvanceApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addFeeAdvanceApply(XN632670Req req);

    public void approveApply(String code, String approveResult, String updater,
            String remark);

    public void financeApproveApply(String code, String approveResult,
            String updater, String remark);

    public void sureFk(String code, String payDatetime, String payBankcard,
            String payPdf, String updater);

    public Paginable<FeeAdvanceApply> queryFeeAdvanceApplyPage(int start,
            int limit, FeeAdvanceApply condition);

    public List<FeeAdvanceApply> queryFeeAdvanceApplyList(
            FeeAdvanceApply condition);

    public FeeAdvanceApply getFeeAdvanceApply(String code);

}
