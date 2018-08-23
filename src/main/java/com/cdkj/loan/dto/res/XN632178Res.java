package com.cdkj.loan.dto.res;

/**
 * 预打款统计
 * @author: jiafr 
 * @since: 2018年8月20日 下午5:52:53 
 * @history:
 */
public class XN632178Res {

    private String companyCode;// 业务公司编号

    private String companyName;// 业务公司名称

    private String totalAdvanceFund;// 垫资总额

    private String hasAdvanceFund;// 已垫资金额

    private String unAdvanceFund;// 未垫资金额

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTotalAdvanceFund() {
        return totalAdvanceFund;
    }

    public void setTotalAdvanceFund(String totalAdvanceFund) {
        this.totalAdvanceFund = totalAdvanceFund;
    }

    public String getHasAdvanceFund() {
        return hasAdvanceFund;
    }

    public void setHasAdvanceFund(String hasAdvanceFund) {
        this.hasAdvanceFund = hasAdvanceFund;
    }

    public String getUnAdvanceFund() {
        return unAdvanceFund;
    }

    public void setUnAdvanceFund(String unAdvanceFund) {
        this.unAdvanceFund = unAdvanceFund;
    }

}
