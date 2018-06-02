package com.cdkj.loan.dto.req;

public class XN632307Req {

    private String budgetOrderCode;// 准入单编号

    private String realName;// 客户姓名

    private String advanceFundDatetimeStart;// 垫资日期始

    private String advanceFundDatetimeEnd;// 垫资日期止

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAdvanceFundDatetimeStart() {
        return advanceFundDatetimeStart;
    }

    public void setAdvanceFundDatetimeStart(String advanceFundDatetimeStart) {
        this.advanceFundDatetimeStart = advanceFundDatetimeStart;
    }

    public String getAdvanceFundDatetimeEnd() {
        return advanceFundDatetimeEnd;
    }

    public void setAdvanceFundDatetimeEnd(String advanceFundDatetimeEnd) {
        this.advanceFundDatetimeEnd = advanceFundDatetimeEnd;
    }

}
