package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderFeeAO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.exception.BizException;

@Service
public class BudgetOrderFeeAOImpl implements IBudgetOrderFeeAO {

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Override
    public String addBudgetOrderFee(BudgetOrderFee data) {
        return budgetOrderFeeBO.saveBudgetOrderFee(data);
    }

    @Override
    public int editBudgetOrderFee(BudgetOrderFee data) {
        if (!budgetOrderFeeBO.isBudgetOrderFeeExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return budgetOrderFeeBO.refreshBudgetOrderFee(data);
    }

    @Override
    public int dropBudgetOrderFee(String code) {
        if (!budgetOrderFeeBO.isBudgetOrderFeeExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return budgetOrderFeeBO.removeBudgetOrderFee(code);
    }

    @Override
    public Paginable<BudgetOrderFee> queryBudgetOrderFeePage(int start,
            int limit, BudgetOrderFee condition) {
        return budgetOrderFeeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition) {
        return budgetOrderFeeBO.queryBudgetOrderFeeList(condition);
    }

    @Override
    public BudgetOrderFee getBudgetOrderFee(String code) {
        return budgetOrderFeeBO.getBudgetOrderFee(code);
    }
}
