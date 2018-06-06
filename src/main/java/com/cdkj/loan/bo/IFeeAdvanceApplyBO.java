package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.FeeAdvanceApply;

public interface IFeeAdvanceApplyBO extends IPaginableBO<FeeAdvanceApply> {

    // 申请
    public void saveFeeAdvanceApply(FeeAdvanceApply data);

    // 审批
    public void refreshFeeAdvanceApplyApprove(FeeAdvanceApply data,
            String status, String updater, String remark);

    // 财务审批
    public void refreshFeeAdvanceApplyFinanceApprove(FeeAdvanceApply data,
            String status, String updater, String remark);

    // 确认放款
    public void sureFk(FeeAdvanceApply data);

    public List<FeeAdvanceApply> queryFeeAdvanceApplyList(
            FeeAdvanceApply condition);

    public FeeAdvanceApply getFeeAdvanceApply(String code);

}
