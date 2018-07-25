package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ContractImport;

//dao层 
public interface IContractImportDAO extends IBaseDAO<ContractImport> {
    String NAMESPACE = IContractImportDAO.class.getName().concat(".");

    int update(ContractImport data);
}
