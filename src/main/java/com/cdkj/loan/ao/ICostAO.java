package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cost;
import com.cdkj.loan.dto.req.XN630535Req;

public interface ICostAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addCost(String repayPlanCode, String overdueTreatmentCode,
            List<XN630535Req> list);

    public int dropCost(String code);

    public Paginable<Cost> queryCostPage(int start, int limit, Cost condition);

    public List<Cost> queryCostList(Cost condition);

    public Cost getCost(String code);

}
