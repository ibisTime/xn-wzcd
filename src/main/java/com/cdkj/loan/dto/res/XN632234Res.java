package com.cdkj.loan.dto.res;

/**
 * 修改贷款金额计算关联数据
 * @author: jiafr 
 * @since: 2018年6月28日 下午10:14:24 
 * @history:
 */
public class XN632234Res {

    private String companyLoanCs;

    private String bankLoanCs;

    private String globalRate;

    public String getCompanyLoanCs() {
        return companyLoanCs;
    }

    public void setCompanyLoanCs(String companyLoanCs) {
        this.companyLoanCs = companyLoanCs;
    }

    public String getBankLoanCs() {
        return bankLoanCs;
    }

    public void setBankLoanCs(String bankLoanCs) {
        this.bankLoanCs = bankLoanCs;
    }

    public String getGlobalRate() {
        return globalRate;
    }

    public void setGlobalRate(String globalRate) {
        this.globalRate = globalRate;
    }

}
