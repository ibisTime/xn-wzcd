package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.enums.ERefType;
import com.cdkj.loan.enums.ERepayBizStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class RepayBizBOImpl extends PaginableBOImpl<RepayBiz>
        implements IRepayBizBO {

    @Autowired
    private IRepayBizDAO repayBizDAO;

    @Override
    public boolean isRepayBizExist(String code) {
        RepayBiz condition = new RepayBiz();
        condition.setCode(code);
        if (repayBizDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepayBiz(RepayBiz data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("RB");
            data.setCode(code);
            repayBizDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepayBiz(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz data = new RepayBiz();
            data.setCode(code);
            count = repayBizDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepayBiz(RepayBiz data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = repayBizDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizDAO.selectList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        RepayBiz data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayBiz condition = new RepayBiz();
            condition.setCode(code);
            data = repayBizDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

    @Override
    public RepayBiz genereateNewCarLoanRepayBiz(LoanOrder data) {

        RepayBiz condition = new RepayBiz();

        String code = null;
        code = OrderNoGenerater.generate("RB");
        condition.setCode(code);
        condition.setRefType(ERefType.CAR.getCode());
        condition.setRefCode(data.getCode());
        condition.setBizPrice(data.getCarPrice());
        condition.setSfRate(data.getSfRate());

        condition.setSfAmount(data.getSfAmount());
        condition.setLoanBank(data.getLoanBank());
        condition.setLoanAmount(data.getLoanAmount());
        condition.setPeriods(data.getPeriods());
        // int daysBetween = DateUtil.daysBetween(data.getFirstRepayDatetime(),
        // new Date());
        // int periods = data.getPeriods();
        // int restPeriods = periods - daysBetween / 30;
        condition.setRestPeriods(0);

        condition.setBankRate(data.getBankRate());
        condition.setLoanStartDatetime(data.getLoanStartDatetime());
        condition.setLoanEndDatetime(data.getLoanEndDatetime());
        condition.setFxDeposit(data.getFxDeposit());
        condition.setFirstRepayDatetime(data.getFirstRepayDatetime());

        condition.setFirstRepayAmount(data.getFirstRepayAmount());
        condition.setMonthDatetime(data.getMonthDatetime());
        condition.setMonthAmount(data.getMonthAmount());
        condition.setLyDeposit(data.getLyDeposit());
        condition.setCutLyDeposit(0L);

        condition.setStatus(ERepayBizStatus.REPAYMENTS.getCode());
        Long monthAmount = data.getMonthAmount();
        int periods = data.getPeriods();
        long amount = monthAmount * (long) (periods - 1);
        condition.setRestAmount(amount);
        condition.setRestTotalCost(0L);
        condition.setTotalInDeposit(0L);
        condition.setOverdueAmount(0L);

        condition.setTotalOverdueCount(0);
        condition.setCurOverdueCount(0);
        condition.setBlackHandleNote("暂无");
        condition.setUpdater(data.getUpdater());
        condition.setUpdateDatetime(new Date());

        condition.setRemark(data.getRemark());
        return condition;
    }
}
