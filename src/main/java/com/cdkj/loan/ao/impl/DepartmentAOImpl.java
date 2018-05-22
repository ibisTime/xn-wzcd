package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN630100Req;
import com.cdkj.loan.dto.req.XN630102Req;
import com.cdkj.loan.enums.EDepartmentStatus;

@Service
public class DepartmentAOImpl implements IDepartmentAO {

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addDepartment(XN630100Req req) {
        Department data = new Department();
        data.setName(req.getName());
        data.setLeadName(req.getLeadName());
        data.setMobile(req.getMobile());
        data.setParentCode(req.getParentCode());
        data.setStatus(EDepartmentStatus.AVAILABLE.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return departmentBO.saveDepartment(data);
    }

    @Override
    public int editDepartment(XN630102Req req) {
        Department data = departmentBO.getDepartment(req.getCode());

        data.setName(req.getName());
        data.setLeadName(req.getLeadName());
        data.setMobile(req.getMobile());
        data.setParentCode(req.getParentCode());
        data.setStatus(EDepartmentStatus.AVAILABLE.getCode());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return departmentBO.refreshDepartment(data);
    }

    @Override
    public int editStatus(String code) {
        Department date = departmentBO.getDepartment(code);
        date.setStatus(EDepartmentStatus.UNAVAILABLE.getCode());
        return departmentBO.refreshStatus(date);
    }

    @Override
    public Paginable<Department> queryDepartmentPage(int start, int limit,
            Department condition) {
        return departmentBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Department> queryDepartmentList(Department condition) {
        return departmentBO.queryDepartmentList(condition);
    }

    @Override
    public Department getDepartment(String code) {
        return departmentBO.getDepartment(code);
    }
}
