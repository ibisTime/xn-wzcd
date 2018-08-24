package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CompanyClearance;
import com.cdkj.loan.dto.req.XN632350Req;

@Component
public interface ICompanyClearanceAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addCompanyClearance(XN632350Req req);

    public Paginable<CompanyClearance> queryCompanyClearancePage(int start,
            int limit, CompanyClearance condition);

    public List<CompanyClearance> queryCompanyClearanceList(
            CompanyClearance condition);

    public CompanyClearance getCompanyClearance(int id);

}
