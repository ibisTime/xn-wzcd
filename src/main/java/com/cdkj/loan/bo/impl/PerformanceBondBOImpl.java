package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IPerformanceBondBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IPerformanceBondDAO;
import com.cdkj.loan.domain.PerformanceBond;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class PerformanceBondBOImpl extends PaginableBOImpl<PerformanceBond>
        implements IPerformanceBondBO {

    @Autowired
    private IPerformanceBondDAO performanceBondDAO;

    public void savePerformanceBond(PerformanceBond data) {
        performanceBondDAO.insert(data);
    }

    @Override
    public void refreshPerformanceBond(PerformanceBond data) {
        performanceBondDAO.update(data);
    }

    @Override
    public List<PerformanceBond> queryPerformanceBondList(
            PerformanceBond condition) {
        return performanceBondDAO.selectList(condition);
    }

    @Override
    public PerformanceBond getPerformanceBond(int id) {
        PerformanceBond data = null;
        if (id != 0) {
            PerformanceBond condition = new PerformanceBond();
            condition.setId(id);
            data = performanceBondDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "履约保证金开票编号不存在！");
            }
        }
        return data;
    }

    @Override
    public PerformanceBond getPerformanceBondByBudget(String budgetCode) {
        PerformanceBond performanceBond = new PerformanceBond();
        performanceBond.setBudgetCode(budgetCode);
        return performanceBondDAO.select(performanceBond);
    }
}
