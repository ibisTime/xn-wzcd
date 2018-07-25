package com.cdkj.loan.dto.req;

public class XN632250ReqContract {

    // 合同号
    private String contractCode;

    // 客户姓名
    private String customerName;

    // 身份证号
    private String idNo;

    // 信用卡号
    private String bankCardNumber;

    // 合同签订日
    private String contractSignDate;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

}
