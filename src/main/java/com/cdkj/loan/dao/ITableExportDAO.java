package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.TableExport;

//dao层 
public interface ITableExportDAO extends IBaseDAO<TableExport> {
	String NAMESPACE = ITableExportDAO.class.getName().concat(".");
}