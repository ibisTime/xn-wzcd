package com.cdkj.loan.dto.req;

/**
 * 垫资超过1天未放款客户
 * @author: CYL 
 * @since: 2018年8月22日 下午5:55:43 
 * @history:
 */
public class XN630911Req extends APageReq {

    private static final long serialVersionUID = -939306905107710022L;

    // 业务编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 贷款银行编号（支行编号）
    private String loanBankCode;

    // 汽车经销商编号
    private String carDealerCode;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

}
