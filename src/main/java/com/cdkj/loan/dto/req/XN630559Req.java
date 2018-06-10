package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630559Req {

    @NotBlank
    private String code;// 编号

    private String buyOutAmount;// 团队买断扣除金额

    private String way;// 0=坏账，1=业务团队买断，2=业务团队租赁

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBuyOutAmount() {
        return buyOutAmount;
    }

    public void setBuyOutAmount(String buyOutAmount) {
        this.buyOutAmount = buyOutAmount;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
