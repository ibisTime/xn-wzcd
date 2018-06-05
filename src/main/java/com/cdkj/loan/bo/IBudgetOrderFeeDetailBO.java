package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:12:12 
 * @history:
 */
public interface IBudgetOrderFeeDetailBO extends
        IPaginableBO<BudgetOrderFeeDetail> {

    // 新增手续费明细
    public String saveBudgetOrderFeeDetail(BudgetOrderFeeDetail data);

    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition);

    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code);

}
