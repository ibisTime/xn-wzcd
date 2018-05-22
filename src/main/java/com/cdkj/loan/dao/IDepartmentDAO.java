package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Department;

//dao层 
public interface IDepartmentDAO extends IBaseDAO<Department> {
    String NAMESPACE = IDepartmentDAO.class.getName().concat(".");

    int update(Department data);

    int updateStatus(Department data);
}
