package com.cdkj.loan.bo.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
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
    public RepayPlan genereateNewRapayPlan(RepayBiz repayBiz) {

        RepayPlan condition = new RepayPlan();

        String code = null;
        code = OrderNoGenerater.generate("BC");
        condition.setCode(code);
        condition.setRepayBizCode(repayBiz.getCode());
        condition.setUserId(repayBiz.getUserId());
        condition.setPeriods(repayBiz.getPeriods());
        condition.setCurPeriods(1);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) + 1;
        int month = cal.get(Calendar.MONTH) + 1;
        cal.add(Calendar.MONTH, 1);
        Date time = cal.getTime();
        condition.setRepayDatetime(time);
        Long monthAmount = repayBiz.getMonthAmount();
        double bankRate = repayBiz.getBankRate();
        Long repayCapital = monthAmount / (long) (bankRate + 1);
        condition.setRepayCapital(repayCapital);
        condition.setRepayInterest(repayBiz.getBankRate());
        condition.setPayedAmount(0L);
        condition.setOverdueAmount(0L);

        condition.setStatus(ERepayPlanStatus.REPAYMENTS.getCode());
        condition.setTotalFee(0L);
        condition.setPayedFee(0L);
        condition.setOverdueDeposit(0L);
        condition.setShouldDeposit(0L);

        condition.setRemindCount(0);
        return condition;
    }
}
