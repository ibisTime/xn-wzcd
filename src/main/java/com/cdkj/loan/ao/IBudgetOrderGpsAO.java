package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.dto.req.XN632342Req;

@Component
public interface IBudgetOrderGpsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String saveBudgetOrderGps(XN632342Req req);

    public void abandonBudgetOrderGps(String code, String remark,
            String operator);

    public Paginable<BudgetOrderGps> queryBudgetOrderGpsPage(int start,
            int limit, BudgetOrderGps condition);

    public List<BudgetOrderGps> queryBudgetOrderGpsList(
            BudgetOrderGps condition);

    public BudgetOrderGps getBudgetOrderGps(String code);

}
