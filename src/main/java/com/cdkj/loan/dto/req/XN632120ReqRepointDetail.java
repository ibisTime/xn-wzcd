package com.cdkj.loan.dto.req;

public class XN632120ReqRepointDetail {

    // 协议id
    private String protocolId;

    // 预算单编号
    private String budgetCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 业务公司编号
    private String companyCode;

    // 用款用途
    private String useMoneyPurpose;

    // 返点金额(返点金额或应退按揭款)
    private Long repointAmount;

    // 账号编号（公司或车行的收款账号编号）
    private String accountCode;

    // 收款账号（用于客户不垫资，手动输入的应退按揭款的收款账号 ）
    private String mortgageAccountNo;

    public String getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(String protocolId) {
        this.protocolId = protocolId;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public Long getRepointAmount() {
        return repointAmount;
    }

    public void setRepointAmount(Long repointAmount) {
        this.repointAmount = repointAmount;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getMortgageAccountNo() {
        return mortgageAccountNo;
    }

    public void setMortgageAccountNo(String mortgageAccountNo) {
        this.mortgageAccountNo = mortgageAccountNo;
    }

}
