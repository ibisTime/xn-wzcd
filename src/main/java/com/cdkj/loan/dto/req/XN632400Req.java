package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增奖金提成配置
 * @author: CYL 
 * @since: 2018年8月20日 下午7:17:00 
 * @history:
 */
public class XN632400Req {

    // 是否自主开发
    @NotBlank
    private String isSelfDevelop;

    // 提成单价
    @NotBlank
    private String unitPrice;

    // 本月比例
    @NotBlank
    private String monthRate;

    // 留存月数
    @NotBlank
    private String retainMonths;

    // 起始金额
    @NotBlank
    private String startAmount;

    // 结束金额
    @NotBlank
    private String endAmount;

    // 最新修改人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(String monthRate) {
        this.monthRate = monthRate;
    }

    public String getRetainMonths() {
        return retainMonths;
    }

    public void setRetainMonths(String retainMonths) {
        this.retainMonths = retainMonths;
    }

    public String getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(String startAmount) {
        this.startAmount = startAmount;
    }

    public String getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(String endAmount) {
        this.endAmount = endAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
