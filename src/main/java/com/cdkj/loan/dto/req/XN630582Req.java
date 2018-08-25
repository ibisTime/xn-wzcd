package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630582Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 拍卖日期
    @NotBlank
    private String saleDatetime;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(String saleDatetime) {
        this.saleDatetime = saleDatetime;
    }

}
