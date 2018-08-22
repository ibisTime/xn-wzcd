package com.cdkj.loan.dto.req;

public class XN630910Req extends APageReq {

    private static final long serialVersionUID = 6290180317847603427L;

    // 编号
    private String budgetCode;

    // 客户类型
    private String customerType;

    // 客户姓名
    private String customerName;

    // 汽车经销商编号
    private String carDealerCode;

    // 贷款银行编号（支行编号）
    private String loanBankCode;

    // 业务公司编号
    private String companyCode;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
