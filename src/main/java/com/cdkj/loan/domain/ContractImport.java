package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 银行合同导入
* @author: CYunlai 
* @since: 2018-07-24 19:43:42
* @history:
*/
public class ContractImport extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 合同号
    private String contractCode;

    // 预算单编号
    private String budgetOrderCode;

    // 客户姓名
    private String customerName;

    // 身份证号
    private String idNo;

    // 贷款金额
    private Long loanAmount;

    // 银行
    private String bankCode;

    // 账单日
    private Integer billDatetime;

    // 还款日
    private Integer repayBankDate;

    // 信用卡号
    private String bankCardNumber;

    // 合同签订日
    private Date contractSignDate;

    // 导入日期
    private Date importDatetime;

    // 状态
    private String status;

    // 操作人
    private String operator;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getBillDatetime() {
        return billDatetime;
    }

    public void setBillDatetime(Integer billDatetime) {
        this.billDatetime = billDatetime;
    }

    public Integer getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(Integer repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public Date getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(Date contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public Date getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(Date importDatetime) {
        this.importDatetime = importDatetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
