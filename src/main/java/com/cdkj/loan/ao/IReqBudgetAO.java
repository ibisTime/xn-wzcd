package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.dto.req.XN632100Req;
import com.cdkj.loan.dto.req.XN632101Req;

@Component
public interface IReqBudgetAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addReqBudget(XN632100Req req);

    public int dropReqBudget(String code);

    public int editReqBudget(ReqBudget data);

    public Paginable<ReqBudget> queryReqBudgetPage(int start, int limit,
            ReqBudget condition);

    public List<ReqBudget> queryReqBudgetList(ReqBudget condition);

    public ReqBudget getReqBudget(String code);

    public int editNode(XN632101Req req);

}
