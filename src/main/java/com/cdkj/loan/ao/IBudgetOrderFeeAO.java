package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFee;

/**
 * 手续费
 * @author: jiafr 
 * @since: 2018年5月30日 下午8:25:26 
 * @history:
 */
@Component
public interface IBudgetOrderFeeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 新增手续费
    public String addBudgetOrderFee(BudgetOrderFee data);

    // 删除手续费
    public int dropBudgetOrderFee(String code);

    // 修改手续费
    public int editBudgetOrderFee(BudgetOrderFee data);

    // 手续费分页查询
    public Paginable<BudgetOrderFee> queryBudgetOrderFeePage(int start,
            int limit, BudgetOrderFee condition);

    // 手续费列表查询
    public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition);

    // 查询手续费
    public BudgetOrderFee getBudgetOrderFee(String code);

}
