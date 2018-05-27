package com.cdkj.loan.dto.req;

/**
 * 利率明细
 * @author: silver 
 * @since: 2018年5月27日 下午7:57:13 
 * @history:
 */
public class XN632030ReqRate {
    // 期数
    private String period;

    // 利率
    private String rate;

    // 备注
    private String remark;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
