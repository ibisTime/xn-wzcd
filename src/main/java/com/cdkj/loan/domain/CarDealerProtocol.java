package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 经销商协议表
 * @author: CYL 
 * @since: 2018年7月8日 下午9:56:49 
 * @history:
 */
public class CarDealerProtocol extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private int id;// 序号

    private String carDealerCode;// 经销商编号

    private String bankCode;// 银行编号

    private Double platCtRate12;// 我司12期基准利率

    private Double platCtRate24;// 我司24期基准利率

    private Double platCtRate36;// 我司36期基准利率

    private Double platZkRate12;// 我司12期基准利率

    private Double platZkRate24;// 我司24期基准利率

    private Double platZkRate36;// 我司36期基准利率

    private String assureType;// 担保费类型(1单笔/2贷款额百分比)

    private Long assureFee;// 单笔担保费

    private Double assureRate;// 担保费贷款额百分比

    private String dzType;// 垫资费类型(1单笔/2贷款额百分比)

    private Long dzFee;// 单笔垫资费

    private Double dzRate;// 垫资费贷款额百分比

    private String lyAmountType;// 履约保证金类型(1单笔/2贷款额百分比)

    private Long lyAmountFee;// 单笔履约保证金

    private Double lyAmountRate;// 履约保证金贷款额百分比

    private String gpsType;// GPS类型(1单笔/2贷款额百分比)

    private Long gpsFee;// 单笔GPS费

    private Double gpsRate;// GPS垫资费贷款额百分比

    private String otherType;// 杂费类型(1单笔/2贷款额百分比)

    private Long otherFee;// 单笔杂费

    private Double otherRate;// 杂费贷款额百分比

    private String introduceType;// 介绍费类型(1单笔/2贷款额百分比)

    private Long introduceFee;// 单笔介绍费

    private Double introduceRate;// 介绍费贷款额百分比

    private String returnPointType;// 返点类型(1单笔/2贷款额百分比)

    private Long returnPointFee;// 单笔返点

    private Double returnPointRate;// 返点贷款额百分比

    private String isDz;// 是否垫资(1 是 0 否)

    private String insuAgencyYear1Type;// 1年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear1Fee;// 1年保险代理费

    private String insuAgencyYear2Type;// 2年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear2Fee;// 2年保险代理费

    private String insuAgencyYear3Type;// 3年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear3Fee;// 3年保险代理费

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Double getPlatCtRate12() {
        return platCtRate12;
    }

    public void setPlatCtRate12(Double platCtRate12) {
        this.platCtRate12 = platCtRate12;
    }

    public Double getPlatCtRate24() {
        return platCtRate24;
    }

    public void setPlatCtRate24(Double platCtRate24) {
        this.platCtRate24 = platCtRate24;
    }

    public Double getPlatCtRate36() {
        return platCtRate36;
    }

    public void setPlatCtRate36(Double platCtRate36) {
        this.platCtRate36 = platCtRate36;
    }

    public Double getPlatZkRate12() {
        return platZkRate12;
    }

    public void setPlatZkRate12(Double platZkRate12) {
        this.platZkRate12 = platZkRate12;
    }

    public Double getPlatZkRate24() {
        return platZkRate24;
    }

    public void setPlatZkRate24(Double platZkRate24) {
        this.platZkRate24 = platZkRate24;
    }

    public Double getPlatZkRate36() {
        return platZkRate36;
    }

    public void setPlatZkRate36(Double platZkRate36) {
        this.platZkRate36 = platZkRate36;
    }

    public String getAssureType() {
        return assureType;
    }

    public void setAssureType(String assureType) {
        this.assureType = assureType;
    }

    public Long getAssureFee() {
        return assureFee;
    }

    public void setAssureFee(Long assureFee) {
        this.assureFee = assureFee;
    }

    public Double getAssureRate() {
        return assureRate;
    }

    public void setAssureRate(Double assureRate) {
        this.assureRate = assureRate;
    }

    public String getDzType() {
        return dzType;
    }

    public void setDzType(String dzType) {
        this.dzType = dzType;
    }

    public Long getDzFee() {
        return dzFee;
    }

    public void setDzFee(Long dzFee) {
        this.dzFee = dzFee;
    }

    public Double getDzRate() {
        return dzRate;
    }

    public void setDzRate(Double dzRate) {
        this.dzRate = dzRate;
    }

    public String getLyAmountType() {
        return lyAmountType;
    }

    public void setLyAmountType(String lyAmountType) {
        this.lyAmountType = lyAmountType;
    }

    public Long getLyAmountFee() {
        return lyAmountFee;
    }

    public void setLyAmountFee(Long lyAmountFee) {
        this.lyAmountFee = lyAmountFee;
    }

    public Double getLyAmountRate() {
        return lyAmountRate;
    }

    public void setLyAmountRate(Double lyAmountRate) {
        this.lyAmountRate = lyAmountRate;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public Double getGpsRate() {
        return gpsRate;
    }

    public void setGpsRate(Double gpsRate) {
        this.gpsRate = gpsRate;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public Long getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Long otherFee) {
        this.otherFee = otherFee;
    }

    public Double getOtherRate() {
        return otherRate;
    }

    public void setOtherRate(Double otherRate) {
        this.otherRate = otherRate;
    }

    public String getIntroduceType() {
        return introduceType;
    }

    public void setIntroduceType(String introduceType) {
        this.introduceType = introduceType;
    }

    public Long getIntroduceFee() {
        return introduceFee;
    }

    public void setIntroduceFee(Long introduceFee) {
        this.introduceFee = introduceFee;
    }

    public Double getIntroduceRate() {
        return introduceRate;
    }

    public void setIntroduceRate(Double introduceRate) {
        this.introduceRate = introduceRate;
    }

    public String getReturnPointType() {
        return returnPointType;
    }

    public void setReturnPointType(String returnPointType) {
        this.returnPointType = returnPointType;
    }

    public Long getReturnPointFee() {
        return returnPointFee;
    }

    public void setReturnPointFee(Long returnPointFee) {
        this.returnPointFee = returnPointFee;
    }

    public Double getReturnPointRate() {
        return returnPointRate;
    }

    public void setReturnPointRate(Double returnPointRate) {
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

    public Long getInsuAgencyYear1Fee() {
        return insuAgencyYear1Fee;
    }

    public void setInsuAgencyYear1Fee(Long insuAgencyYear1Fee) {
        this.insuAgencyYear1Fee = insuAgencyYear1Fee;
    }

    public String getInsuAgencyYear2Type() {
        return insuAgencyYear2Type;
    }

    public void setInsuAgencyYear2Type(String insuAgencyYear2Type) {
        this.insuAgencyYear2Type = insuAgencyYear2Type;
    }

    public Long getInsuAgencyYear2Fee() {
        return insuAgencyYear2Fee;
    }

    public void setInsuAgencyYear2Fee(Long insuAgencyYear2Fee) {
        this.insuAgencyYear2Fee = insuAgencyYear2Fee;
    }

    public String getInsuAgencyYear3Type() {
        return insuAgencyYear3Type;
    }

    public void setInsuAgencyYear3Type(String insuAgencyYear3Type) {
        this.insuAgencyYear3Type = insuAgencyYear3Type;
    }

    public Long getInsuAgencyYear3Fee() {
        return insuAgencyYear3Fee;
    }

    public void setInsuAgencyYear3Fee(Long insuAgencyYear3Fee) {
        this.insuAgencyYear3Fee = insuAgencyYear3Fee;
    }

}
