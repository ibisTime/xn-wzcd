package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.EmployApply;
import com.cdkj.loan.dto.req.XN632850Req;
import com.cdkj.loan.dto.req.XN632851Req;

@Component
public interface IEmployApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请应聘
    public String addEmployApply(XN632850Req req);

    // 面试
    public void interviewEmployApply(XN632851Req req);

    public Paginable<EmployApply> queryEmployApplyPage(int start, int limit,
            EmployApply condition);

    public List<EmployApply> queryEmployApplyList(EmployApply condition);

    public EmployApply getEmployApply(String code);

}
