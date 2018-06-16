package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ReplaceRepayPlan;

public interface IReplaceRepayPlanBO extends IPaginableBO<ReplaceRepayPlan> {

    public boolean isReplaceRepayPlanExist(String code);

    public String saveReplaceRepayPlan(ReplaceRepayPlan data);

    // 风控经理审核
    public void updateRiskManageApprove(String code, String curNodeCode,
            String riskNote, String remark, String operator);

    // 分公司总经理审核
    public void updateSubcompApprove(String code, String curNodeCode,
            String remark, String operator);

    // 风控总监审核
    public void updateRiskChiefApprove(String code, String curNodeCode,
            String remark, String operator);

    // 财务经理审核
    public void updateFianaceApprove(String code, String curNodeCode,
            String remark, String operator);

    // 确认放款
    public void updateConfirmLoan(ReplaceRepayPlan data);

    public List<ReplaceRepayPlan> queryReplaceRepayPlanList(
            ReplaceRepayPlan condition);

    public ReplaceRepayPlan getReplaceRepayPlan(String code);

}
