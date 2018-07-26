package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IContractImportDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ContractImport;

@Repository("contractImportDAOImpl")
public class ContractImportDAOImpl extends AMybatisTemplate
        implements IContractImportDAO {

    @Override
    public int insert(ContractImport data) {
        return super.insert(NAMESPACE.concat("insert_contractImport"), data);
    }

    @Override
    public int delete(ContractImport data) {
        return super.delete(NAMESPACE.concat("delete_contractImport"), data);
    }

    @Override
    public ContractImport select(ContractImport condition) {
        return super.select(NAMESPACE.concat("select_contractImport"),
            condition, ContractImport.class);
    }

    @Override
    public long selectTotalCount(ContractImport condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_contractImport_count"), condition);
    }

    @Override
    public List<ContractImport> selectList(ContractImport condition) {
        return super.selectList(NAMESPACE.concat("select_contractImport"),
            condition, ContractImport.class);
    }

    @Override
    public List<ContractImport> selectList(ContractImport condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_contractImport"),
            start, count, condition, ContractImport.class);
    }

    @Override
    public int update(ContractImport condition) {
        return super.update(NAMESPACE.concat("update_contractImport"),
            condition);
    }

}
