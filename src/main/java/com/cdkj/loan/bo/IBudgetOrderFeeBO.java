package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrderFee;

/**
 * 手续费
 * @author: jiafr 
 * @since: 2018年5月30日 下午8:28:04 
 * @history:
 */
public interface IBudgetOrderFeeBO extends IPaginableBO<BudgetOrderFee> {

    public boolean isBudgetOrderFeeExist(String code);

    // 手续费新增
    public String saveBudgetOrderFee(BudgetOrderFee data);

    public int removeBudgetOrderFee(String code);

    public int refreshBudgetOrderFee(BudgetOrderFee data);

    public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition);

    public BudgetOrderFee getBudgetOrderFee(String code);

}
