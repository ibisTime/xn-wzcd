package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 奖金提成配置
* @author: CYunlai 
* @since: 2018-08-20 18:56:06
* @history:
*/
public class SysBonuses extends ABaseDO {

    private static final long serialVersionUID = -2831390391337229179L;

    // id
    private int id;

    // 是否自主开发(1是，0否)
    private String isSelfDevelop;

    // 提成单价
    private Long unitPrice;

    // 本月比例
    private Double monthRate;

    // 留存月数
    private Integer retainMonths;

    // 起始金额
    private Long startAmount;

    // 结束金额
    private Long endAmount;

    // 备注
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(Double monthRate) {
        this.monthRate = monthRate;
    }

    public Integer getRetainMonths() {
        return retainMonths;
    }

    public void setRetainMonths(Integer retainMonths) {
        this.retainMonths = retainMonths;
    }

    public Long getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Long startAmount) {
        this.startAmount = startAmount;
    }

    public Long getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(Long endAmount) {
        this.endAmount = endAmount;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
