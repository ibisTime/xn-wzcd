package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;
import com.cdkj.loan.dto.req.XN632160Req;

/**
 * 手续费明细
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:11:28 
 * @history:
 */
@Component
public interface IBudgetOrderFeeDetailAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 新增手续费明细
    public String addBudgetOrderFeeDetail(XN632160Req req);

    public Paginable<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailPage(
            int start, int limit, BudgetOrderFeeDetail condition);

    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition);

    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code);

}
