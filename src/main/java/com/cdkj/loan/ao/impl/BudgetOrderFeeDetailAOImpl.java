package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderFeeDetailAO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderFeeDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.enums.EBoolean;

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

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Override
    @Transactional
    public String addBudgetOrderFeeDetail(BudgetOrderFeeDetail data) {
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO.getBudgetOrderFee(data
            .getFeeCode());

        budgetOrderFee.setRealAmount(budgetOrderFee.getRealAmount()
                + data.getAmount());
        if (budgetOrderFee.getRealAmount().longValue() >= budgetOrderFee
            .getShouldAmount().longValue()) {
            budgetOrderFee.setIsSettled(EBoolean.YES.getCode());
        } else {
            budgetOrderFee.setIsSettled(EBoolean.NO.getCode());
        }
        budgetOrderFeeBO.refreshBudgetOrderFee(budgetOrderFee);
        return budgetOrderFeeDetailBO.saveBudgetOrderFeeDetail(data);
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
