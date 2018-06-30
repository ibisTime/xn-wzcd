package com.cdkj.loan.dto.res;

import java.util.List;

/**
 * 修改贷款金额计算关联数据
 * @author: jiafr 
 * @since: 2018年6月28日 下午10:14:24 
 * @history:
 */
public class XN632234Res {

    // 我司贷款成数
    private String companyLoanCs;

    // 银行贷款成数
    private String bankLoanCs;

    // 综合利率
    private String globalRate;

    // 担保风险金
    private String fxAmount;

    // 履约保证金
    private String lyAmount;

    // gps收费
    private String gpsFee;

    // 杂费
    private String otherFee;

    // 油补
    private String oilSubsidy;

    // gps提成
    private String gpsDeduct;

    // 返点明细（用款用途）
    private List<XN632290Res> list;

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

    public String getFxAmount() {
        return fxAmount;
    }

    public void setFxAmount(String fxAmount) {
        this.fxAmount = fxAmount;
    }

    public String getLyAmount() {
        return lyAmount;
    }

    public void setLyAmount(String lyAmount) {
        this.lyAmount = lyAmount;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public String getGpsDeduct() {
        return gpsDeduct;
    }

    public void setGpsDeduct(String gpsDeduct) {
        this.gpsDeduct = gpsDeduct;
    }

    public List<XN632290Res> getList() {
        return list;
    }

    public void setList(List<XN632290Res> list) {
        this.list = list;
    }

}
