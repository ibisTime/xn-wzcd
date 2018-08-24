package com.cdkj.loan.domain;

import java.util.Date;

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

    // 最新修改人
    private String updater;

    // 最新修改时间
    private Date updaterDatetime;

    // 备注
    private String remark;

    /*----------辅助字段-------------*/

    // 最新修改人姓名
    private String updaterName;

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdaterDatetime() {
        return updaterDatetime;
    }

    public void setUpdaterDatetime(Date updaterDatetime) {
        this.updaterDatetime = updaterDatetime;
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
