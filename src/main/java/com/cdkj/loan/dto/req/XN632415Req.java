package com.cdkj.loan.dto.req;

public class XN632415Req extends APageReq {
    private static final long serialVersionUID = 7416893983435548075L;

    // 业务员
    private String saleUser;

    // 是否自主开发
    private String isSelfDevelop;

    // 放款月份起
    private String monthStart;

    // 放款月份止
    private String monthEnd;

    public String getSaleUser() {
        return saleUser;
    }

    public void setSaleUser(String saleUser) {
        this.saleUser = saleUser;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(String monthEnd) {
        this.monthEnd = monthEnd;
    }

}
