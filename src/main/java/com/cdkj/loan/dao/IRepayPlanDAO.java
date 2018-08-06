package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayPlan;

public interface IRepayPlanDAO extends IBaseDAO<RepayPlan> {
    String NAMESPACE = IRepayPlanDAO.class.getName().concat(".");

    public void insertList(List<RepayPlan> dataList);

    public int repayResultHandle(RepayPlan data);

    public int updateOverdue(RepayPlan repayPlan);

    public int updateOverdueHandle(RepayPlan repayPlan);

    public int repayPartSuccess(RepayPlan repayPlan);

    public int payFee(RepayPlan repayPlan);

    public int repayAmount(RepayPlan repayPlan);

    // 收车申请
    public int updateTakeCarApply(RepayPlan data);

    // 确认放款
    public int updateTakeCarSureFk(RepayPlan data);

    // 录入收车结果
    public int updateTakeCarInputResult(RepayPlan data);

    // 结果处理
    public int updateTakeCarResultHandle(RepayPlan data);

    // 每天凌晨定时更新还款计划状态为已结清
    public int updatePayedDaily(RepayPlan data);

    public long selectTotalCountByRoleCode(RepayPlan condition);

    public List<RepayPlan> selectRepayPlanByRoleCode(RepayPlan condition,
            int start, int pageSize);

    public void updateRepayPlan(RepayPlan repayPlan);

    // 还款计划的已还金额改为当月月供
    public void updateRepayPlanPayedAmount(RepayPlan repayPlan);

}
