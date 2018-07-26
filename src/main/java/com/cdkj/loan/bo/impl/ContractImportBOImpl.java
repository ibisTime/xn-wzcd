package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IContractImportBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IContractImportDAO;
import com.cdkj.loan.domain.ContractImport;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class ContractImportBOImpl extends PaginableBOImpl<ContractImport>
        implements IContractImportBO {

    @Autowired
    private IContractImportDAO contractImportDAO;

    public String saveContractImport(ContractImport data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CONTRACT_IMPORT.getCode());
            data.setCode(code);
            contractImportDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeContractImport(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ContractImport data = new ContractImport();
            data.setCode(code);
            count = contractImportDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshContractImport(ContractImport data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = contractImportDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ContractImport> queryContractImportList(
            ContractImport condition) {
        return contractImportDAO.selectList(condition);
    }

    @Override
    public ContractImport getContractImport(String code) {
        ContractImport data = null;
        if (StringUtils.isNotBlank(code)) {
            ContractImport condition = new ContractImport();
            condition.setCode(code);
            data = contractImportDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在！");
            }
        }
        return data;
    }
}
