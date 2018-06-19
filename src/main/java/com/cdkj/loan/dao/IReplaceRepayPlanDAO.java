package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ReplaceRepayPlan;

public interface IReplaceRepayPlanDAO extends IBaseDAO<ReplaceRepayPlan> {
    String NAMESPACE = IReplaceRepayPlanDAO.class.getName().concat(".");

    // 风控经理审核
    public void updateRiskManageApprove(ReplaceRepayPlan data);

    // 分公司总经理审核
    public void updateSubcompApprove(ReplaceRepayPlan data);

    // 风控总监审核
    public void updateRiskChiefApprove(ReplaceRepayPlan data);

    // 财务经理审核
    public void updateFianaceApprove(ReplaceRepayPlan data);

    // 确认放款
    public void updateConfirmLoan(ReplaceRepayPlan data);

    // 根据角色编号查总数
    public long selectTotalCountByRoleCode(ReplaceRepayPlan data);

    // 根据角色编号查列表
    public List<ReplaceRepayPlan> selectReplaceRepayPlanByRoleCodeList(
            ReplaceRepayPlan condition, int start, int limit);
}
