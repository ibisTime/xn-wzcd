package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IDepartmentDAO;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.enums.EDepartmentType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class DepartmentBOImpl extends PaginableBOImpl<Department>
        implements IDepartmentBO {

    @Autowired
    private IDepartmentDAO departmentDAO;

    public String saveDepartment(Department data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.DEPARTMENT.getCode());
            data.setCode(code);
            departmentDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshStatus(Department data) {
        return departmentDAO.updateStatus(data);
    }

    @Override
    public int refreshDepartment(Department data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = departmentDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Department> queryDepartmentList(Department condition) {
        return departmentDAO.selectList(condition);
    }

    @Override
    public String getDepartmentByPost(String postCode) {
        String departmentCode = postCode;
        // 部门编号
        while (true) {
            Department department = getDepartment(departmentCode);
            if (EDepartmentType.DEPARTMENT.getCode()
                .equals(department.getType())) {
                departmentCode = department.getCode();
                break;
            } else {
                departmentCode = department.getParentCode();
            }
        }
        return departmentCode;
    }

    @Override
    public String getCompanyByDepartment(String departmentCode) {
        // 公司编号
        String companyCode = departmentCode;
        while (true) {
            Department company = getDepartment(companyCode);
            if (EDepartmentType.SUBBRANCH_COMPANY.getCode()
                .equals(company.getType())) {
                companyCode = company.getCode();
                break;
            } else {
                companyCode = company.getParentCode();
            }
        }
        return companyCode;
    }

    @Override
    public Department getDepartment(String code) {
        Department data = null;
        if (StringUtils.isNotBlank(code)) {
            Department condition = new Department();
            condition.setCode(code);
            data = departmentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "部门不存在");
            }
        }
        return data;
    }
}
