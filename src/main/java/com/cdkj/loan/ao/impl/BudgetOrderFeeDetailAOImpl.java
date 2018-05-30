package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderFeeDetailAO;
import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.exception.BizException;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:07:49 
 * @history:
 */
@Service
public class BudgetOrderFeeDetailAOImpl implements IBudgetOrderFeeDetailAO {

    @Autowired
    private IBudgetOrderFeeDetailBO budgetOrderFeeDetailBO;

    @Override
    public String addBudgetOrderFeeDetail(BudgetOrderFeeDetail data) {
        return budgetOrderFeeDetailBO.saveBudgetOrderFeeDetail(data);
    }

    @Override
    public int editBudgetOrderFeeDetail(BudgetOrderFeeDetail data) {
        if (!budgetOrderFeeDetailBO.isBudgetOrderFeeDetailExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return budgetOrderFeeDetailBO.refreshBudgetOrderFeeDetail(data);
    }

    @Override
    public int dropBudgetOrderFeeDetail(String code) {
        if (!budgetOrderFeeDetailBO.isBudgetOrderFeeDetailExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return budgetOrderFeeDetailBO.removeBudgetOrderFeeDetail(code);
    }

    @Override
    public Paginable<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailPage(
            int start, int limit, BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition) {
        return budgetOrderFeeDetailBO.queryBudgetOrderFeeDetailList(condition);
    }

    @Override
    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code) {
        return budgetOrderFeeDetailBO.getBudgetOrderFeeDetail(code);
    }
}
