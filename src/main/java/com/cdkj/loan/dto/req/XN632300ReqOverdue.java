package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632300ReqOverdue {

    @NotBlank
    private String realName;//

    @NotBlank
    private String idNo;// 证件号

    @NotBlank
    private String loanAmount;// 贷款金额

    @NotBlank
    private String fkDatetime;// 放款日期

    @NotBlank
    private String periods;// 总期数

    @NotBlank
    private String overdueAmount;// 逾期金额

    @NotBlank
    private String overdueDatetime;// 逾期日期

    @NotBlank
    private String remainAmount;// 剩余金额

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getFkDatetime() {
        return fkDatetime;
    }

    public void setFkDatetime(String fkDatetime) {
        this.fkDatetime = fkDatetime;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(String overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getOverdueDatetime() {
        return overdueDatetime;
    }

    public void setOverdueDatetime(String overdueDatetime) {
        this.overdueDatetime = overdueDatetime;
    }

    public String getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(String remainAmount) {
        this.remainAmount = remainAmount;
    }

}
