package com.cdkj.loan.ao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICostAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.ICostBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.IRemindLogBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.domain.RemindLog;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.ERepayBizType;
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
    private IRepayBizAO repayBizAO;

    @Autowired
    private ICostAO costAO;

    @Autowired
    private ICostBO costBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    IRemindLogBO remindLogBO;

    @Autowired
    IBankcardBO bankcardBO;

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
            repayPlan.setRepayBiz(repayBizAO.getRepayBiz(repayPlan
                .getRepayBizCode()));

        }

        // RepayPlan repayPlan = repayPlanBO.getRepayPlan(condition.getCode());
        // Cost cost = new Cost();
        // cost.setRepayPlanCode(condition.getCode());
        // List<Cost> list = costBO.queryCostList(cost);
        // repayPlan.setCostList(list);
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
        repayPlan.setRepayBiz(repayBizBO.getRepayBiz(repayPlan
            .getRepayBizCode()));
        Cost cost = new Cost();
        cost.setRepayPlanCode(code);
        List<Cost> list = costBO.queryCostList(cost);
        repayPlan.setCostList(list);

        RemindLog remindLog = new RemindLog();
        remindLog.setRepayPlanCode(code);
        List<RemindLog> remindLogList = remindLogBO
            .queryRemindLogList(remindLog);
        repayPlan.setRemindLogList(remindLogList);

        String bankcardCode = repayBizBO.getRepayBiz(
            repayPlan.getRepayBizCode()).getBankcardCode();
        String bankcardNumber = bankcardBO.getBankcard(bankcardCode)
            .getBankcardNumber();
        repayPlan.setBankcardNumber(bankcardNumber);

        repayPlan.setUser(userBO.getUser(repayPlan.getUserId()));
        repayPlan.setRepayBiz(repayBizAO.getRepayBiz(repayPlan
            .getRepayBizCode()));

        return repayPlan;
    }

    @Override
    @Transactional
    public void repayMonthly(String code) {

        // 查询还款计划
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(code);

        // 查询还款业务
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan.getRepayBizCode());

        // 校验是否是可还款状态
        if (!ERepayPlanStatus.TO_REPAYMENTS.getCode().equals(
            repayPlan.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "本期还款计划不处于待还款状态");
        }

        // 检查是否有未还清的还款计划
        if (repayPlanBO.checkPreUnpay(repayPlan.getRepayBizCode(),
            repayPlan.getCurPeriods())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "本期之前您还有未还款的计划");
        }

        // 本次应扣款的金额
        Long shouldWithholdAmount = repayPlan.getOverplusAmount();

        // 还款卡获取
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());

        // 宝付代扣发起，返回本次真实扣成功的金额
        Long realWithholdAmount = baofuWithhold(bankcard, shouldWithholdAmount);

        // 该还款计划本次代扣完成后剩余应还金额
        Long overplusAmount = shouldWithholdAmount - realWithholdAmount;

        if (overplusAmount <= 0) {// 本次计划还清了

            repayAll(repayPlan, repayBiz, realWithholdAmount);

        } else { // 扣了一部分

            repayPart(repayPlan, repayBiz, realWithholdAmount);

        }

    }

    private void repayPart(RepayPlan repayPlan, RepayBiz repayBiz,
            Long realWithholdAmount) {
        // 还剩多少 付了多少
        // 1、更新本次还款计划的剩余应还款金额和已支付金额
        repayPlanBO.repayPartSuccess(repayPlan, realWithholdAmount);

        // 2、更新还款业务的剩余总额
        repayBizBO.refreshRestAmount(repayBiz, realWithholdAmount);
    }

    private void repayAll(RepayPlan repayPlan, RepayBiz repayBiz,
            Long realWithholdAmount) {
        // 更新还款计划
        repayPlanBO.repaySuccess(repayPlan, realWithholdAmount);

        // 更新还款业务剩余金额
        repayBizBO.refreshRestAmount(repayBiz, realWithholdAmount);

        // 检查是否已经全部正常还款
        if (repayPlanBO.checkRepayComplete(repayPlan.getRepayBizCode())) {
            repayBizBO.repaySuccessNormal(repayPlan.getRepayBizCode());
        }

        // 增加信用分
        addCreditScore(repayPlan, repayBiz);
    }

    private void addCreditScore(RepayPlan repayPlan, RepayBiz repayBiz) {
        // 加信用分
        Account account = accountBO.getAccountByUser(repayPlan.getUserId(),
            ECurrency.XYF.getCode());

        // 判断是汽车还是商品
        String refType = repayBiz.getRefType();
        BigDecimal changeScore = null;
        if (refType.equals(ERepayBizType.CAR.getCode())) {
            changeScore = sysConfigBO
                .getBigDecimalValue(SysConstants.CAR_NORMAL);
        } else {
            changeScore = sysConfigBO
                .getBigDecimalValue(SysConstants.PRODUCT_NORMAL);
        }
        creditscoreBO.changeCreditscore(account, changeScore,
            repayPlan.getCode(), "按月正常还款");
    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;

        // TODO 宝付代扣逻辑
        successAmount = amount;

        return successAmount;
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
            repayPlan.setRepayBiz(repayBizBO.getRepayBiz(repayPlan
                .getRepayBizCode()));
            Long monthRepayAmount = repayPlan.getRepayCapital()
                    * repayPlan.getRepayInterest();
            repayPlan.setMonthRepayAmount(monthRepayAmount);
        }
        return results;
    }

    // 逾期处理
    @Override
    @Transactional
    public void OverdueHandle(XN630532Req req) {

        RepayPlan repayPlan = repayPlanBO.getRepayPlan(req.getCode());

        if (!ERepayPlanStatus.OVERDUE_TO_HANDLE.getCode().equals(
            repayPlan.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该条还款计划不是逾期状态！！！");
        }

        // 删除原来费用清单
        costAO.dropCost(req.getCode());

        // 添加费用清单
        costAO.addCost(req.getCode(), req.getCostList());

        // 更新还款计划
        repayPlan.setOverdueDeposit(StringValidater.toLong(req
            .getOverdueDeposit()));
        repayPlan.setDepositWay(req.getOverdueDepositWay());
        repayPlan.setOverdueHandleNote(req.getRemark());
        repayPlanBO.refreshRepayPlanOverdue(repayPlan);

        // 判断是否提交扣款
        if (req.getIsSubmit().equals(EBoolean.YES.getCode())) {
            // TODO 代扣

            if ("1" == "1") {
                // 代扣成功
                ToGreen(req.getCode(), req.getOverdueDeposit());
            }
        }

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

    @Override
    public Long getUnsettledLoan() {
        RepayPlan condition = new RepayPlan();
        List<RepayPlan> results = repayPlanBO.queryRepayPlanList(condition);
        Long unsettledLoan = 0L;
        for (RepayPlan repayPlan : results) {
            if (repayPlan.getStatus().equals(
                ERepayPlanStatus.OVERDUE_TO_HANDLE.getCode())
                    || repayPlan.getStatus().equals(
                        ERepayPlanStatus.HESUAN_TO_GREEN.getCode())) {
                Long amount = repayPlan.getTotalFee() - repayPlan.getPayedFee()
                        + repayPlan.getOverplusAmount();
                unsettledLoan = unsettledLoan + amount;
            }
        }
        return unsettledLoan;
    }

}
