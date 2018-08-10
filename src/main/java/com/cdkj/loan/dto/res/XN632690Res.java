package com.cdkj.loan.dto.res;

public class XN632690Res {

    private String initialAmount;// 首期月供

    private String annualAmount;// 每期月供

    private String poundage;// 手续费

    public String getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(String initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getAnnualAmount() {
        return annualAmount;
    }

    public void setAnnualAmount(String annualAmount) {
        this.annualAmount = annualAmount;
    }

    public String getPoundage() {
        return poundage;
    }

    public void setPoundage(String poundage) {
        this.poundage = poundage;
    }

}
