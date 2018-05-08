package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.ICUserBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ERepayPlanStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayPlanAOImpl implements IRepayPlanAO {

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private ICUserBO cUserBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Override
    public String addRepayPlan(RepayPlan data) {
        return repayPlanBO.saveRepayPlan(data);
    }

    @Override
    public int editRepayPlan(RepayPlan data) {
        if (!repayPlanBO.isRepayPlanExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return repayPlanBO.refreshRepayPlan(data);
    }

    @Override
    public int dropRepayPlan(String code) {
        if (!repayPlanBO.isRepayPlanExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return repayPlanBO.removeRepayPlan(code);
    }

    @Override
    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition) {
        condition.setRepayStartDatetime(DateUtil.getFristDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(cUserBO.getUser(repayPlan.getUserId()));
        }

        return results;
    }

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanBO.queryRepayPlanList(condition);
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setUser(cUserBO.getUser(repayPlan.getUserId()));
        return repayPlan;
    }

    @Override
    public void repayMonthly(String code) {

        // 查询还款计划
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);

        // 校验是否是可还款状态
        if (!ERepayPlanStatus.TO_REPAYMENTS.getCode()
            .equals(repayPlan.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "本期还款计划不处于待还款状态");
        }

        // 检查是否有未还清的还款计划
        if (repayPlanBO.checkPreUnpay(repayPlan.getRepayBizCode(),
            repayPlan.getCurPeriods())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "本期之前您还有未还款的计划");
        }

        // TODO 发起宝付代扣
        Long payAmount = repayPlan.getRepayCapital()
                + repayPlan.getRepayInterest() + repayPlan.getOverdueAmount();

        // 支付成功，更新还款计划
        repayPlanBO.repaySuccess(repayPlan, payAmount);

        // 检查是否已经全部正常还款
        if (repayPlanBO.checkRepayComplete(repayPlan.getRepayBizCode())) {
            repayBizBO.repayCompleteNormal(repayPlan.getRepayBizCode());
        }

    }

}
