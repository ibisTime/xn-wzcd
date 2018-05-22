package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Department;

//CHECK 
@Component
public interface IDepartmentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addDepartment(Department data);

    public int dropDepartment(String code);

    public int editDepartment(Department data);

    public Paginable<Department> queryDepartmentPage(int start, int limit,
            Department condition);

    public List<Department> queryDepartmentList(Department condition);

    public Department getDepartment(String code);

}
