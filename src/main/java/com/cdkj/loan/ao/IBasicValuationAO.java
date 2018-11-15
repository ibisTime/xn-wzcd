package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BasicValuation;
import com.cdkj.loan.dto.req.XN630450Req;

@Component
public interface IBasicValuationAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addBasicValuation(BasicValuation data);

    public Paginable<BasicValuation> queryBasicValuationPage(int start,
            int limit, BasicValuation condition);

    public List<BasicValuation> queryBasicValuationList(
            BasicValuation condition);

    public BasicValuation getBasicValuation(int id);

    // 基础估值
    public Object basicValuation(XN630450Req req);

}
