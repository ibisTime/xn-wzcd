package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IContractImportAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IContractImportBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.ContractImport;
import com.cdkj.loan.dto.req.XN632250ReqContract;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EContractImportStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class ContractImportAOImpl implements IContractImportAO {

    @Autowired
    private IContractImportBO contractImportBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    public void importContract(String loanBankCode,
            List<XN632250ReqContract> contractList, String operator) {
        // 遍历
        for (XN632250ReqContract contract : contractList) {
            // 按客户姓名和身份证号查找
            BudgetOrder condition = new BudgetOrder();
            condition.setCustomerName(contract.getCustomerName());
            condition.setIdNo(contract.getIdNo());
            List<BudgetOrder> budgetOrderList = budgetOrderBO
                .queryBudgetOrderList(condition);

            ContractImport contractImport = new ContractImport();
            contractImport.setStatus(EContractImportStatus.NOT_MATCH.getCode());
            // 不为空，待处理，否则都是不匹配
            if (CollectionUtils.isNotEmpty(budgetOrderList)) {
                BudgetOrder budgetOrder = budgetOrderList.get(0);
                contractImport.setBudgetOrderCode(budgetOrder.getCode());
                contractImport.setCustomerName(budgetOrder.getCustomerName());
                contractImport.setIdNo(budgetOrder.getIdNo());
                contractImport.setLoanAmount(budgetOrder.getLoanAmount());
                contractImport.setBillDatetime(budgetOrder.getBillDatetime());
                contractImport.setRepayBankDate(budgetOrder.getRepayBankDate());
                contractImport.setStatus(EContractImportStatus.MATCH.getCode());
            }
            contractImport.setBankCode(loanBankCode);
            contractImport.setContractCode(contract.getContractCode());
            contractImport.setBankCardNumber(contract.getBankCardNumber());
            contractImport.setContractSignDate(
                DateUtil.strToDate(contract.getContractSignDate(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            contractImport.setImportDatetime(new Date());
            contractImport.setOperator(operator);
            contractImportBO.saveContractImport(contractImport);
        }
    }

    @Override
    public void handleContract(String code, String budgetOrderCode,
            String operator) {
        ContractImport contractImport = contractImportBO
            .getContractImport(code);
        if (!EContractImportStatus.NOT_MATCH.getCode()
            .equals(contractImport.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该合同不处于不匹配状态，不能操作！");
        }
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(budgetOrderCode);
        contractImport.setBudgetOrderCode(budgetOrder.getCode());
        contractImport.setCustomerName(budgetOrder.getCustomerName());
        contractImport.setIdNo(budgetOrder.getIdNo());
        contractImport.setLoanAmount(budgetOrder.getLoanAmount());
        contractImport.setBillDatetime(budgetOrder.getBillDatetime());
        contractImport.setRepayBankDate(budgetOrder.getRepayBankDate());
        contractImport.setStatus(EContractImportStatus.HANDLE.getCode());
        contractImport.setOperator(operator);
        contractImportBO.refreshContractImport(contractImport);
    }

    @Override
    public String addContractImport(ContractImport data) {
        return contractImportBO.saveContractImport(data);
    }

    @Override
    public int editContractImport(ContractImport data) {
        return contractImportBO.refreshContractImport(data);
    }

    @Override
    public int dropContractImport(String code) {
        return contractImportBO.removeContractImport(code);
    }

    @Override
    public Paginable<ContractImport> queryContractImportPage(int start,
            int limit, ContractImport condition) {
        return contractImportBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ContractImport> queryContractImportList(
            ContractImport condition) {
        return contractImportBO.queryContractImportList(condition);
    }

    @Override
    public ContractImport getContractImport(String code) {
        return contractImportBO.getContractImport(code);
    }

}
