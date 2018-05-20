package com.cdkj.loan.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ERepayBizStatus;
import com.cdkj.loan.enums.ERepayPlanStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayPlanBOImpl extends PaginableBOImpl<RepayPlan>
        implements IRepayPlanBO {

    @Autowired
    private IRepayPlanDAO repayPlanDAO;

    @Override
    public boolean isRepayPlanExist(String code) {
        RepayPlan condition = new RepayPlan();
        condition.setCode(code);
        if (repayPlanDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepayPlan(RepayPlan data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("RP");
            data.setCode(code);
            repayPlanDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepayPlan(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan data = new RepayPlan();
            data.setCode(code);
            count = repayPlanDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepayPlan(RepayPlan data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repayPlanDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan condition = new RepayPlan();
            condition.setCode(code);
            data = repayPlanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

    @Override
    public void genereateNewRapayPlan(RepayBiz repayBiz) {

        List<RepayPlan> repayPlanList = new ArrayList<RepayPlan>();

        for (int i = 0; i < repayBiz.getPeriods(); i++) {

            RepayPlan repayPlan = new RepayPlan();

            int curPeriod = i + 1;

            String code = OrderNoGenerater.generate("RP");

            Long repayCapital = repayBiz.getMonthAmount();
            if (i == 0) {
                repayCapital = repayBiz.getFirstRepayAmount();
            }

            Date repayDatetime = getRepayDatetime(
                repayBiz.getFirstRepayDatetime(), repayBiz.getMonthDatetime(),
                curPeriod);

            repayPlan.setCode(code);
            repayPlan.setRepayBizCode(repayBiz.getCode());
            repayPlan.setUserId(repayBiz.getUserId());
            repayPlan.setPeriods(repayBiz.getPeriods());
            repayPlan.setCurPeriods(curPeriod);

            repayPlan.setRepayDatetime(repayDatetime);
            repayPlan.setRepayCapital(repayCapital);
            repayPlan.setRepayInterest(0L);
            repayPlan.setPayedAmount(0L);

            // 每期应还金额
            long shouldRepayAmount = repayPlan.getRepayCapital()
                    + repayPlan.getRepayInterest();
            repayPlan.setOverplusAmount(shouldRepayAmount);

            repayPlan.setOverdueAmount(0L);
            repayPlan.setStatus(ERepayBizStatus.TO_REPAYMENTS.getCode());
            repayPlan.setTotalFee(0L);
            repayPlan.setPayedFee(0L);
            repayPlan.setOverdueDeposit(0L);

            repayPlan.setShouldDeposit(0L);
            repayPlan.setRemindCount(0);

            repayPlanList.add(repayPlan);
        }

        repayPlanDAO.insertList(repayPlanList);
    }

    @Override
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan
            .setPayedAmount(repayPlan.getPayedAmount() + realWithholdAmount);

        repayPlan.setOverplusAmount(
            repayPlan.getOverplusAmount() - realWithholdAmount);

        repayPlan.setStatus(ERepayBizStatus.YET_REPAYMENTS.getCode());

        repayPlanDAO.repaySuccess(repayPlan);

    }

    @Override
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan
            .setPayedAmount(repayPlan.getPayedAmount() + realWithholdAmount);

        repayPlan.setOverplusAmount(
            repayPlan.getOverplusAmount() - realWithholdAmount);

        repayPlanDAO.repayPartSuccess(repayPlan);
    }

    /**
     * @param firstRepayDatetime 第一期还款时间
     * @param monthDatetime 每月还款日期
     * @param period 第几期
     * @return 
     * @create: 2018年5月6日 下午3:44:31 haiqingzheng
     * @history:
     */
    private Date getRepayDatetime(Date firstRepayDatetime, int monthDatetime,
            int curPeriod) {
        Date repayDatetime = null;
        if (curPeriod < 1) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "计算每月还款日期发送错误，还款期数必须大于0");
        }
        if (curPeriod == 1) {
            repayDatetime = firstRepayDatetime;
        } else {
            repayDatetime = DateUtil.getIntervalDate(firstRepayDatetime,
                curPeriod - 1, monthDatetime);
        }
        return repayDatetime;
    }

    @Override
    public boolean checkRepayComplete(String repayBizCode) {

        boolean isComplete = true;

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);

        List<RepayPlan> repayPlans = repayPlanDAO.selectList(condition);

        if (CollectionUtils.isNotEmpty(repayPlans)) {

            for (RepayPlan repayPlan : repayPlans) {
                if (!ERepayPlanStatus.YET_REPAYMENTS.getCode()
                    .equals(repayPlan.getStatus())
                        && !ERepayPlanStatus.HESUAN_TO_GREEN.getCode()
                            .equals(repayPlan.getStatus())) {
                    isComplete = false;
                    break;
                }
            }

        }

        return isComplete;

    }

    @Override
    public boolean checkPreUnpay(String repayBizCode, int curPeriod) {

        boolean flag = false;

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setOrder("cur_periods", true);
        List<RepayPlan> repayPlans = repayPlanDAO.selectList(condition);

        if (CollectionUtils.isNotEmpty(repayPlans)) {

            for (RepayPlan repayPlan : repayPlans) {
                if (repayPlan.getCurPeriods() >= curPeriod) {
                    break;
                }
                if (!ERepayPlanStatus.YET_REPAYMENTS.getCode()
                    .equals(repayPlan.getStatus())
                        && !ERepayPlanStatus.HESUAN_TO_GREEN.getCode()
                            .equals(repayPlan.getStatus())) {
                    flag = true;
                    break;
                }
            }

        }

        return flag;

    }

    @Override
    public int refreshRepayPlanStatus(RepayPlan data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repayPlanDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public int refreshRepayPlanOverdue(RepayPlan repayPlan) {
        return repayPlanDAO.OverdueHandle(repayPlan);
    }

    @Override
    public int refreshToGreen(RepayPlan repayPlan) {
        return repayPlanDAO.OverdueHandle(repayPlan);
    }

    @Override
    public int refreshToBlack(RepayPlan repayPlan) {
        return repayPlanDAO.OverdueHandle(repayPlan);
    }

}
