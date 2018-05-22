package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Department;




public interface IDepartmentBO extends IPaginableBO<Department> {


	public String saveDepartment(Department data);


	public int removeDepartment(String code);


	public int refreshDepartment(Department data);


	public List<Department> queryDepartmentList(Department condition);


	public Department getDepartment(String code);


}