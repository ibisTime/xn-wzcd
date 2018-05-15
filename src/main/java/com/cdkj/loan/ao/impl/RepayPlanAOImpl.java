package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICostAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.ICostBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EIsSubmit;
import com.cdkj.loan.enums.ERepayPlanStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayPlanAOImpl implements IRepayPlanAO {

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private ICostAO costAO;

    @Autowired
    private ICostBO costBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

    @Autowired
    IAccountBO accountBO;

    @Override
    public String addRepayPlan(RepayPlan data) {
        return repayPlanBO.saveRepayPlan(data);
    }

    @Override
    public int editRepayPlan(RepayPlan data) {
        if (!repayPlanBO.isRepayPlanExist(data.getCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "记录编号不存在");
        }
        return repayPlanBO.refreshRepayPlan(data);
    }

    @Override
    public int dropRepayPlan(String code) {
        if (!repayPlanBO.isRepayPlanExist(code)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "记录编号不存在");
        }
        return repayPlanBO.removeRepayPlan(code);
    }

    @Override
    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition) {
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
            repayPlan.setRepayBiz(
                repayBizBO.getRepayBiz(repayPlan.getRepayBizCode()));
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
        repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        repayPlan
            .setRepayBiz(repayBizBO.getRepayBiz(repayPlan.getRepayBizCode()));
        Cost cost = new Cost();
        cost.setRepayPlanCode(code);
        List<Cost> list = costBO.queryCostList(cost);
        repayPlan.setCostList(list);
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

        // 加信用分

        // Account account = accountBO.getAccountByUser(repayPlan.getUserId(),
        // ECurrency.XYF.getCode());
        // creditscoreBO.changeCreditscore(account, changeScore,
        // repayPlan.getCode(), "按月正常还款");

        // 检查是否已经全部正常还款
        if (repayPlanBO.checkRepayComplete(repayPlan.getRepayBizCode())) {
            repayBizBO.repayCompleteNormal(repayPlan.getRepayBizCode());
        }

    }

    // 当月还款名单
    @Override
    public Object dyRepayment(int start, int limit, RepayPlan condition) {
        condition.setRepayStartDatetime(DateUtil.getFirstDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        Paginable<RepayPlan> results = repayPlanBO.getPaginable(start, limit,
            condition);
        for (RepayPlan repayPlan : results.getList()) {
            repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        }
        return results;
    }

    // 逾期处理
    @Override
    public void OverdueHandle(XN630532Req req) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());
        // 费用清单
        costAO.addCost(req.getCode(), req.getCostList());
        Cost cost = new Cost();
        cost.setRepayPlanCode(req.getCode());
        costBO.queryCostList(cost);
        if (req.getIsSubmit().equals(EIsSubmit.SUBMIT.getCode())) {
            repayPlan.setStatus(ERepayPlanStatus.HESUAN_TO_GREEN.getCode());
            // 代扣
        }
        repayPlan
            .setOverdueDeposit(StringValidater.toLong(req.getOverdueDeposit()));
        repayPlan.setDepositWay(req.getOverdueDepositWay());
        repayPlan.setOverdueHandleNote(req.getRemark());
        repayPlanBO.refreshRepayPlanOverdue(repayPlan);
    }

    @Override
    public void ToGreen(String code, String overdueDeposit) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setStatus(ERepayPlanStatus.HESUAN_TO_GREEN.getCode());
        repayPlan.setOverdueDeposit(StringValidater.toLong(overdueDeposit));
        repayPlanBO.refreshToGreen(repayPlan);
    }

    @Override
    public void ToBlack(String code) {
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);
        repayPlan.setStatus(ERepayPlanStatus.HESUANNOT_TO_BLACK.getCode());
        repayPlanBO.refreshToBlack(repayPlan);
    }

}
