package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankcardAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.ICUserBO;
import com.cdkj.loan.bo.ILoanOrderBO;
import com.cdkj.loan.bo.IOrderBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.res.BooleanRes;
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
    private IBankcardAO bankcardAO;

    @Autowired
    private ICUserBO cUserBO;

    @Autowired
    private ILoanOrderBO loanOrderBO;

    @Autowired
    private IOrderBO orderBO;

    // 变更银行卡
    @Override
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardAO.addBankcard(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
            req.getRemark());
    }

    // 变更银行卡
    @Override
    public void editBankcardModify(XN630511Req req) {
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
            req.getUpdater(), req.getRemark());
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
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

        repayBiz.setUser(cUserBO.getUser(repayBiz.getUserId()));

        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            repayBiz
                .setLoanOrder(loanOrderBO.getLoanOrder(repayBiz.getRefCode()));
        } else {
            repayBiz.setMallOrder(orderBO.getOrder(repayBiz.getRefCode()));
        }

    }

    // 提前还款
    @Override
    public void EarlyRepayment(String code, String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizStatus.TO_REPAYMENTS.getCode()
            .equals(repayBiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "改还款业务不处于还款中，请重新选择！！！");
        }
        // 判断是否逾期
        RepayPlan repayPlan = new RepayPlan();
        repayPlan.setRepayBizCode(code);
        List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(repayPlan);
        for (RepayPlan repayPlan2 : planList) {
            if (repayPlan2.getStatus()
                .equals(ERepayPlanStatus.OVERDUE_TO_HANDLE.getCode())) {
                // 逾期处理
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "已逾期，未处理！！！");
            }
        }
        // 代扣
        BooleanRes res = daiKou(repayBiz);
        if (res.equals(false)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "代扣失败！！！");
        }
        repayBiz.setStatus(ERepayBizStatus.EARLY_REPAYMENT.getCode());
        // 改变还款计划状态
        for (RepayPlan repayPlan2 : planList) {
            repayPlan2.setStatus(ERepayPlanStatus.YET_REPAYMENTS.getCode());
            repayPlanBO.refreshRepayPlanStatus(repayPlan2);
        }
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizBO.refreshStatusEarlyRepayment(repayBiz);
    }

    private BooleanRes daiKou(RepayBiz repayBiz) {
        long dkAmount = repayBiz.getFirstRepayAmount()
                * repayBiz.getRestPeriods();
        return new BooleanRes(true);
    }

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
            .equals(repayBiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "状态不是正常已还款，不能确认结清！！！");
        }
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setStatus(ERepayBizStatus.YET_CLEARANCE.getCode());
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
