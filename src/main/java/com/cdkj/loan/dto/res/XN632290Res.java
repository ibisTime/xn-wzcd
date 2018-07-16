package com.cdkj.loan.dto.res;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:19:59 
 * @history:
 */
public class XN632290Res {

    // 用款用途
    private String useMoneyPurpose;

    // 返点金额(返点金额或应退按揭款)
    private String repointAmount;

    // 账号编号（公司或车行的收款账号编号）
    private String accountCode;

    // 公司名称
    private String companyName;

    // 账号
    private String bankcardNumber;

    // 开户支行
    private String subbranch;

    // 户名
    private String accountName;

    // 基准利率
    private String benchmarkRate;

    public String getBenchmarkRate() {
        return benchmarkRate;
    }

    public void setBenchmarkRate(String benchmarkRate) {
        this.benchmarkRate = benchmarkRate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public String getRepointAmount() {
        return repointAmount;
    }

    public void setRepointAmount(String repointAmount) {
        this.repointAmount = repointAmount;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

}
