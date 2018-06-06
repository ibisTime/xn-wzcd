package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AssertApply;
import com.cdkj.loan.dto.req.XN632640Req;

@Component
public interface IAssertApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addAssertApply(XN632640Req req);

    public int dropAssertApply(String code);

    public int editAssertApply(AssertApply data);

    public Paginable<AssertApply> queryAssertApplyPage(int start, int limit,
            AssertApply condition);

    public List<AssertApply> queryAssertApplyList(AssertApply condition);

    public AssertApply getAssertApply(String code);

}
