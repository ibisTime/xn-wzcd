package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Department;

//CHECK ��鲢��ע�� 
@Service
public class DepartmentAOImpl implements IDepartmentAO {

    @Autowired
    private IDepartmentBO DepartmentBO;

    @Override
    public String addDepartment(Department data) {
        return DepartmentBO.saveDepartment(data);
    }

    @Override
    public int editDepartment(Department data) {
        return DepartmentBO.refreshDepartment(data);
    }

    @Override
    public int dropDepartment(String code) {
        return DepartmentBO.removeDepartment(code);
    }

    @Override
    public Paginable<Department> queryDepartmentPage(int start, int limit,
            Department condition) {
        return DepartmentBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Department> queryDepartmentList(Department condition) {
        return DepartmentBO.queryDepartmentList(condition);
    }

    @Override
    public Department getDepartment(String code) {
        return DepartmentBO.getDepartment(code);
    }
}
