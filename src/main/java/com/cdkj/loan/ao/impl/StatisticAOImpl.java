package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IStatisticAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Department;
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

    @Override
    public List<XN630901Res> carLoanBizStatistic(XN630901Req req) {
        ArrayList<XN630901Res> resList = new ArrayList<XN630901Res>();

        Department companyCondition = new Department();
        companyCondition.setType(EDepartmentType.SUBBRANCH_COMPANY.getCode());
        List<Department> list = departmentBO
            .queryDepartmentList(companyCondition);
        for (Department department : list) {
            XN630901Res res = new XN630901Res();
            res.setCompanyName(department.getName());
            BudgetOrder budgetOrderCondition = new BudgetOrder();
            /*
             * budgetOrderCondition.setBankFkDatetimeStart(date);
             * budgetOrderCondition.setBankFkDatetimeEnd(bankFkDatetimeEnd);
             * budgetOrderBO.queryBudgetOrderList(condition)
             * res.setBorrowAmount(borrowAmount);
             * res.setBorrowOverdueAmount(borrowOverdueAmount);
             */
            resList.add(res);
        }
        return resList;
    }
}
