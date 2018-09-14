package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 逾期记录
* @author: CYunlai 
* @since: 2018-09-14 15:38:40
* @history:
*/
public class OverdueRecord extends ABaseDO {

    private static final long serialVersionUID = 1259966440843179583L;

    // id
    private int id;

    // 业务编号(预算单)
    private String bizCode;

    // 客户姓名
    private String customerName;

    // 标记(0=白名单 1=绿名单 2=黄名单 3=红名单 4=黑名单)
    private String sign;

    // 逾期日期
    private Date overdueDatetime;

    // 逾期金额
    private Long overdueAmount;

    /*-------------辅助字段---------------*/

    // 共还人
    private String ghRealName;

    // 担保人1
    private String guarantor1Name;

    // 担保人2
    private String guarantor2Name;

    public String getGhRealName() {
        return ghRealName;
    }

    public void setGhRealName(String ghRealName) {
        this.ghRealName = ghRealName;
    }

    public String getGuarantor1Name() {
        return guarantor1Name;
    }

    public void setGuarantor1Name(String guarantor1Name) {
        this.guarantor1Name = guarantor1Name;
    }

    public String getGuarantor2Name() {
        return guarantor2Name;
    }

    public void setGuarantor2Name(String guarantor2Name) {
        this.guarantor2Name = guarantor2Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public Date getOverdueDatetime() {
        return overdueDatetime;
    }

    public void setOverdueDatetime(Date overdueDatetime) {
        this.overdueDatetime = overdueDatetime;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

}
