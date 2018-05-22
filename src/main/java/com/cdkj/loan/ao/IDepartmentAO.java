package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN630100Req;
import com.cdkj.loan.dto.req.XN630102Req;

//CHECK 
@Component
public interface IDepartmentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addDepartment(XN630100Req req);

    public int editStatus(String code);

    public int editDepartment(XN630102Req req);

    public Paginable<Department> queryDepartmentPage(int start, int limit,
            Department condition);

    public List<Department> queryDepartmentList(Department condition);

    public Department getDepartment(String code);

}
