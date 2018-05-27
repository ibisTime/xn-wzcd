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
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class DepartmentBOImpl extends PaginableBOImpl<Department> implements
        IDepartmentBO {

    @Autowired
    private IDepartmentDAO departmentDAO;

    public String saveDepartment(Department data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.DEPARTMENT
                .getCode());
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
    public Department getDepartment(String code) {
        Department data = null;
        if (StringUtils.isNotBlank(code)) {
            Department condition = new Department();
            condition.setCode(code);
            data = departmentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}
