package com.cdkj.loan.dto.req;

public class XN632137Req {

    private String companyCode;// 业务公司

    private String customerName;// 客户姓名

    private String carDealerCode;// 汽车经销商

    private String applyDatetimeStart;// 申请时间起始

    private String applyDatetimeEnd;// 申请时间结束

    private String status;// 办理状态

    private String loanBankCode;// 贷款银行

    private String isAdvanceFund;// 是否垫资

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

}
