package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ERepayBizStatus;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayBizAOImpl implements IRepayBizAO {

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderAO budgetOrderAO;

    @Autowired
    private IOrderAO orderAO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private IBankBO bankBO;

    // 变更银行卡
    @Override
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardBO.saveBankcardBiz(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
            req.getRemark());
    }

    // 变更银行卡
    @Override
    public void editBankcardModify(XN630511Req req) {
        bankcardBO.getBankcard(req.getCode());
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
            req.getUpdater(), req.getRemark());
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
            // LoanOrder loanOrder = new LoanOrder();
            // loanOrder.setRepayBizCode(repayBiz.getCode());
            // List<LoanOrder> queryLoanOrderList = loanOrderBO
            // .queryLoanOrderList(loanOrder);
            // repayBiz.setLoanOrderList(queryLoanOrderList);
            setRefInfo(repayBiz);
        }
        return results;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizBO.queryRepayBizList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {

        // 查询实际退款金额
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);

        setRefInfo(repayBiz);

        return repayBiz;
    }

    /** 
     * @param repayBiz 
     * @create: 2018年5月6日 下午5:11:12 haiqingzheng
     * @history: 
     */
    private void setRefInfo(RepayBiz repayBiz) {

        repayBiz.setUser(userBO.getUser(repayBiz.getUserId()));
        RepayPlan condition = new RepayPlan();
        condition.setOrder("cur_periods", true);
        condition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> repayPlanList = repayPlanBO
            .queryRepayPlanList(condition);
        repayBiz.setRepayPlanList(repayPlanList);

        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            repayBiz.setBudgetOrder(
                budgetOrderAO.getBudgetOrder(repayBiz.getRefCode()));
        } else {
            repayBiz.setMallOrder(orderAO.getOrder(repayBiz.getRefCode()));
        }

        Long deposit = repayBiz.getLyDeposit() - repayBiz.getCutLyDeposit();
        Long amount = 0L;
        for (RepayPlan repayPlan2 : repayPlanList) {
            // 实际退款金额
            Long shouldDeposit = repayPlan2.getShouldDeposit();
            deposit = deposit + shouldDeposit;

            // 借款余额
            Long overplusAmount = repayPlan2.getOverplusAmount();
            amount = amount + overplusAmount;
        }
        repayBiz.setActualRefunds(deposit);
        repayBiz.setLoanBalance(amount);
        String bankName = bankBO.getBank(repayBiz.getLoanBank()).getBankName();
        repayBiz.setLoanBankName(bankName);
    }

    // 提前还款
    @Override
    public void EarlyRepayment(String code, String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizStatus.TO_REPAYMENTS.getCode()
            .equals(repayBiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该还款业务不处于还款中，请重新选择！！！");
        }
        // 判断是否逾期
        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(code);
        for (RepayPlan repayPlan : planList) {
            if (!repayPlan.getStatus()
                .equals(ERepayPlanStatus.TO_REPAYMENTS.getCode())
                    && !repayPlan.getStatus()
                        .equals(ERepayPlanStatus.YET_REPAYMENTS.getCode())
                    && !repayPlan.getStatus()
                        .equals(ERepayPlanStatus.HESUAN_TO_GREEN.getCode())) {
                // 逾期处理
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前有逾期未处理完成的还款计划，不能提前还款！");
            }
        }

        // 提前还款服务费
        Long fwAmount = sysConfigBO.getLongValue(SysConstants.TQ_SERVICE);

        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount() + fwAmount;

        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());

        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);

        // 更新还款业务
        repayBizBO.repayEarlySuccess(repayBiz, realWithholdAmount);

        // 改变还款计划状态
        for (RepayPlan repayPlan : planList) {
            if (!ERepayPlanStatus.TO_REPAYMENTS.getCode()
                .equals(repayPlan.getStatus())) {
                continue;
            }
            repayPlan.setStatus(ERepayPlanStatus.YET_REPAYMENTS.getCode());
            repayPlanBO.refreshRepayPlanStatus(repayPlan);
        }

    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;

        // TODO 宝付代扣逻辑

        successAmount = amount;

        return successAmount;
    }

    // private BooleanRes daiKou(RepayBiz repayBiz) {
    // long dkAmount = repayBiz.getFirstRepayAmount()
    // * repayBiz.getRestPeriods();
    // return new BooleanRes(true);
    // }

    @Override
    public void EnterBlackList(String code, String blackHandleNote,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        repayBiz.setBlackHandleNote(blackHandleNote);
        repayBiz.setStatus(ERepayBizStatus.YET_NOT_CONFIRMED.getCode());
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);

        RepayPlan repayPlan = new RepayPlan();
        repayPlan.setRepayBizCode(code);
        List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(repayPlan);
        for (RepayPlan repayPlan2 : planList) {
            repayPlan2.setStatus(ERepayPlanStatus.HESUANNOT_TO_BLACK.getCode());
            repayPlanBO.refreshRepayPlanStatus(repayPlan2);
        }
        repayBizBO.refreshRepayBizStatus(repayBiz);
    }

    @Override
    public void confirmClose(XN630513Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizStatus.YET_REPAYMENTS.getCode()
            .equals(repayBiz.getStatus())
                && !ERepayBizStatus.EARLY_REPAYMENT.getCode()
                    .equals(repayBiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "状态不是正常已还款或提前还款，不能确认结清！！！");
        }
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        if (repayBiz.getStatus()
            .equals(ERepayBizStatus.TO_REPAYMENTS.getCode())) {
            repayBiz.setStatus(ERepayBizStatus.YET_CLEARANCE.getCode());
        } else {
            repayBiz.setStatus(ERepayBizStatus.YET_EARLY_CLEARANCE.getCode());
        }
        repayBiz.setCloseAttach(req.getCloseAttach());
        repayBiz.setCloseDatetime(new Date());
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getRemark());
        RepayPlan repayPlan = new RepayPlan();

        repayPlan.setRepayBizCode(req.getCode());
        List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(repayPlan);
        for (RepayPlan repayPlan2 : planList) {
            repayPlan2.setStatus(ERepayPlanStatus.YET_REPAYMENTS.getCode());
            repayPlanBO.refreshRepayPlanStatus(repayPlan2);
        }
        repayBizBO.confirmClose(repayBiz);
    }
}
