package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增协议
 * @author: CYL 
 * @since: 2018年5月27日 下午1:48:49 
 * @history:
 */
public class XN632060ReqProtocol {

    @NotBlank
    private String carDealerCode;// 经销商编号

    @NotBlank
    private String bankCode;// 银行编号

    @NotBlank
    private String platCtRate12;// 我司12期基准利率

    @NotBlank
    private String platCtRate24;// 我司24期基准利率

    @NotBlank
    private String platCtRate36;// 我司36期基准利率

    @NotBlank
    private String platZkRate12;// 我司12期基准利率

    @NotBlank
    private String platZkRate24;// 我司24期基准利率

    @NotBlank
    private String platZkRate36;// 我司36期基准利率

    @NotBlank
    private String assureType;// 担保费类型(1单笔/2贷款额百分比)

    @NotBlank
    private String assureFee;// 单笔担保费

    @NotBlank
    private String assureRate;// 担保费贷款额百分比

    @NotBlank
    private String dzType;// 垫资费类型(1单笔/2贷款额百分比)

    @NotBlank
    private String dzFee;// 单笔垫资费

    @NotBlank
    private String dzRate;// 垫资费贷款额百分比

    @NotBlank
    private String lyAmountType;// 履约保证金类型(1单笔/2贷款额百分比)

    @NotBlank
    private String lyAmountFee;// 单笔履约保证金

    @NotBlank
    private String lyAmountRate;// 履约保证金贷款额百分比

    @NotBlank
    private String gpsType;// GPS类型(1单笔/2贷款额百分比)

    @NotBlank
    private String gpsFee;// 单笔GPS费

    @NotBlank
    private String gpsRate;// GPS垫资费贷款额百分比

    @NotBlank
    private String otherType;// 杂费类型(1单笔/2贷款额百分比)

    @NotBlank
    private String otherFee;// 单笔杂费

    @NotBlank
    private String otherRate;// 杂费贷款额百分比

    @NotBlank
    private String introduceType;// 介绍费类型(1单笔/2贷款额百分比)

    @NotBlank
    private String introduceFee;// 单笔介绍费

    @NotBlank
    private String introduceRate;// 介绍费贷款额百分比

    @NotBlank
    private String returnPointType;// 返点类型(1单笔/2贷款额百分比)

    @NotBlank
    private String returnPointFee;// 单笔返点

    @NotBlank
    private String returnPointRate;// 返点贷款额百分比

    @NotBlank
    private String isDz;// 是否垫资(1 是 0 否)

    @NotBlank
    private String insuAgencyYear1Type;// 1年保险代理费类型(1平台/2车行)

    private String insuAgencyYear1Fee;// 1年保险代理费

    @NotBlank
    private String insuAgencyYear2Type;// 2年保险代理费类型(1平台/2车行)

    private String insuAgencyYear2Fee;// 2年保险代理费

    @NotBlank
    private String insuAgencyYear3Type;// 3年保险代理费类型(1平台/2车行)

    private String insuAgencyYear3Fee;// 3年保险代理费

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPlatCtRate12() {
        return platCtRate12;
    }

    public void setPlatCtRate12(String platCtRate12) {
        this.platCtRate12 = platCtRate12;
    }

    public String getPlatCtRate24() {
        return platCtRate24;
    }

    public void setPlatCtRate24(String platCtRate24) {
        this.platCtRate24 = platCtRate24;
    }

    public String getPlatCtRate36() {
        return platCtRate36;
    }

    public void setPlatCtRate36(String platCtRate36) {
        this.platCtRate36 = platCtRate36;
    }

    public String getPlatZkRate12() {
        return platZkRate12;
    }

    public void setPlatZkRate12(String platZkRate12) {
        this.platZkRate12 = platZkRate12;
    }

    public String getPlatZkRate24() {
        return platZkRate24;
    }

    public void setPlatZkRate24(String platZkRate24) {
        this.platZkRate24 = platZkRate24;
    }

    public String getPlatZkRate36() {
        return platZkRate36;
    }

    public void setPlatZkRate36(String platZkRate36) {
        this.platZkRate36 = platZkRate36;
    }

    public String getAssureType() {
        return assureType;
    }

    public void setAssureType(String assureType) {
        this.assureType = assureType;
    }

    public String getAssureFee() {
        return assureFee;
    }

    public void setAssureFee(String assureFee) {
        this.assureFee = assureFee;
    }

    public String getAssureRate() {
        return assureRate;
    }

    public void setAssureRate(String assureRate) {
        this.assureRate = assureRate;
    }

    public String getDzType() {
        return dzType;
    }

    public void setDzType(String dzType) {
        this.dzType = dzType;
    }

    public String getDzFee() {
        return dzFee;
    }

    public void setDzFee(String dzFee) {
        this.dzFee = dzFee;
    }

    public String getDzRate() {
        return dzRate;
    }

    public void setDzRate(String dzRate) {
        this.dzRate = dzRate;
    }

    public String getLyAmountType() {
        return lyAmountType;
    }

    public void setLyAmountType(String lyAmountType) {
        this.lyAmountType = lyAmountType;
    }

    public String getLyAmountFee() {
        return lyAmountFee;
    }

    public void setLyAmountFee(String lyAmountFee) {
        this.lyAmountFee = lyAmountFee;
    }

    public String getLyAmountRate() {
        return lyAmountRate;
    }

    public void setLyAmountRate(String lyAmountRate) {
        this.lyAmountRate = lyAmountRate;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getGpsRate() {
        return gpsRate;
    }

    public void setGpsRate(String gpsRate) {
        this.gpsRate = gpsRate;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getOtherRate() {
        return otherRate;
    }

    public void setOtherRate(String otherRate) {
        this.otherRate = otherRate;
    }

    public String getIntroduceType() {
        return introduceType;
    }

    public void setIntroduceType(String introduceType) {
        this.introduceType = introduceType;
    }

    public String getIntroduceFee() {
        return introduceFee;
    }

    public void setIntroduceFee(String introduceFee) {
        this.introduceFee = introduceFee;
    }

    public String getIntroduceRate() {
        return introduceRate;
    }

    public void setIntroduceRate(String introduceRate) {
        this.introduceRate = introduceRate;
    }

    public String getReturnPointType() {
        return returnPointType;
    }

    public void setReturnPointType(String returnPointType) {
        this.returnPointType = returnPointType;
    }

    public String getReturnPointFee() {
        return returnPointFee;
    }

    public void setReturnPointFee(String returnPointFee) {
        this.returnPointFee = returnPointFee;
    }

    public String getReturnPointRate() {
        return returnPointRate;
    }

    public void setReturnPointRate(String returnPointRate) {
        this.returnPointRate = returnPointRate;
    }

    public String getIsDz() {
        return isDz;
    }

    public void setIsDz(String isDz) {
        this.isDz = isDz;
    }

    public String getInsuAgencyYear1Type() {
        return insuAgencyYear1Type;
    }

    public void setInsuAgencyYear1Type(String insuAgencyYear1Type) {
        this.insuAgencyYear1Type = insuAgencyYear1Type;
    }

    public String getInsuAgencyYear1Fee() {
        return insuAgencyYear1Fee;
    }

    public void setInsuAgencyYear1Fee(String insuAgencyYear1Fee) {
        this.insuAgencyYear1Fee = insuAgencyYear1Fee;
    }

    public String getInsuAgencyYear2Type() {
        return insuAgencyYear2Type;
    }

    public void setInsuAgencyYear2Type(String insuAgencyYear2Type) {
        this.insuAgencyYear2Type = insuAgencyYear2Type;
    }

    public String getInsuAgencyYear2Fee() {
        return insuAgencyYear2Fee;
    }

    public void setInsuAgencyYear2Fee(String insuAgencyYear2Fee) {
        this.insuAgencyYear2Fee = insuAgencyYear2Fee;
    }

    public String getInsuAgencyYear3Type() {
        return insuAgencyYear3Type;
    }

    public void setInsuAgencyYear3Type(String insuAgencyYear3Type) {
        this.insuAgencyYear3Type = insuAgencyYear3Type;
    }

    public String getInsuAgencyYear3Fee() {
        return insuAgencyYear3Fee;
    }

    public void setInsuAgencyYear3Fee(String insuAgencyYear3Fee) {
        this.insuAgencyYear3Fee = insuAgencyYear3Fee;
    }

}
