package com.cdkj.loan.dto.res;

/**
 * 协议收费
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:19:59 
 * @history:
 */
public class XN632291Res {

    // 履约保证金
    private String lyAmount;

    // 担保风险金
    private String fxAmount;

    // GPS收费
    private String gpsFee;

    // 杂费
    private String otherFee;

    // 油补
    private String oilSubsidy;

    // GPS提成
    private String gpsDeduct;

    public String getLyAmount() {
        return lyAmount;
    }

    public void setLyAmount(String lyAmount) {
        this.lyAmount = lyAmount;
    }

    public String getFxAmount() {
        return fxAmount;
    }

    public void setFxAmount(String fxAmount) {
        this.fxAmount = fxAmount;
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

}
