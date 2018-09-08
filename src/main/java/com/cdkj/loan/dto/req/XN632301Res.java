package com.cdkj.loan.dto.req;

public class XN632301Res {

    private String code;// 还款业务编号

    private String overdueAmount;// 逾期金额

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(String overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

}
