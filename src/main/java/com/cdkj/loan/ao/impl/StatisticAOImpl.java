package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IStatisticAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630901Req;
import com.cdkj.loan.dto.res.XN630901Res;
import com.cdkj.loan.enums.EDepartmentType;

/**
 * 统计
 * @author: jiafr 
 * @since: 2018年8月3日 下午7:48:39 
 * @history:
 */
@Service
public class StatisticAOImpl implements IStatisticAO {

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Override
    public List<XN630901Res> carLoanBizStatistic(XN630901Req req) {
        ArrayList<XN630901Res> resList = new ArrayList<XN630901Res>();
        String date = calDate(req.getDate(), -1);// 前一天
        Department companyCondition = new Department();
        companyCondition.setType(EDepartmentType.SUBBRANCH_COMPANY.getCode());
        List<Department> list = departmentBO
            .queryDepartmentList(companyCondition);
        for (Department department : list) {
            XN630901Res res = new XN630901Res();
            res.setCompanyName(department.getName());// 分公司名称
            BudgetOrder budgetOrderCondition = new BudgetOrder();
            budgetOrderCondition.setBankFkDatetimeStart(DateUtil
                .getStartDatetime(date));
            budgetOrderCondition.setBankFkDatetimeEnd(DateUtil
                .getEndDatetime(date));
            List<BudgetOrder> budgetOrderList = budgetOrderBO
                .queryBudgetOrderList(budgetOrderCondition);
            Long borrowAmount = 0L;
            for (BudgetOrder budgetOrder : budgetOrderList) {
                borrowAmount += getLong(budgetOrder.getBankFkAmount());
            }
            res.setBorrowAmount(String.valueOf(borrowAmount));// 借方发生额
            RepayPlan repayPlanCondition = new RepayPlan();
            repayPlanCondition.setRepayDatetimeStart(DateUtil
                .getStartDatetime(date));
            repayPlanCondition.setRepayDatetimeEnd(DateUtil
                .getEndDatetime(date));
            List<RepayPlan> repayPlanList = repayPlanBO
                .queryRepayPlanList(repayPlanCondition);
            Long loanAmount = 0L;
            for (RepayPlan repayPlan : repayPlanList) {
                loanAmount += getLong(repayPlan.getRepayAmount());

            }
            res.setLoanAmount(String.valueOf(loanAmount));// 贷方发生额
            resList.add(res);
        }
        return resList;
    }

    private String calDate(String date, int i) {
        Date strToDate = DateUtil.strToDate(date,
            DateUtil.FRONT_DATE_FORMAT_STRING);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strToDate);
        calendar.add(Calendar.DATE, i);
        Date time = calendar.getTime();
        return DateUtil.dateToStr(time, DateUtil.FRONT_DATE_FORMAT_STRING);
    }

    private Long getLong(Object obj) {
        if (null == obj) {
            return 0L;
        } else {
            return (Long) obj;
        }
    }
}
