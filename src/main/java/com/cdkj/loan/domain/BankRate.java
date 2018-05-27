package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 利率明细
 * @author: silver 
 * @since: 2018年5月27日 下午7:18:11 
 * @history:
 */
public class BankRate extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 6570047256724353763L;

    // 序号
    private int id;

    // 银行编号
    private String bankCode;

    // 期数
    private int period;

    // 利率
    private Double rate;

    // 备注
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
