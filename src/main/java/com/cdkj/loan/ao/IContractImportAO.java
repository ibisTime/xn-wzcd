package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ContractImport;
import com.cdkj.loan.dto.req.XN632250ReqContract;

@Component
public interface IContractImportAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addContractImport(ContractImport data);

    public int dropContractImport(String code);

    public int editContractImport(ContractImport data);

    public Paginable<ContractImport> queryContractImportPage(int start,
            int limit, ContractImport condition);

    public List<ContractImport> queryContractImportList(
            ContractImport condition);

    public ContractImport getContractImport(String code);

    // 银行合同导入
    public void importContract(String loanBankCode,
            List<XN632250ReqContract> contractList, String operator);

    // 银行合同处理
    public void handleContract(String code, String budgetOrderCode,
            String operator);

}
