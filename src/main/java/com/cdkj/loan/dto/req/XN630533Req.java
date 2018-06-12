package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN630533Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotEmpty
    private List<String> costList; // 费用清单列表

    @NotBlank
    private String payType;// 1=线上代扣 2=线下归还

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCostList() {
        return costList;
    }

    public void setCostList(List<String> costList) {
        this.costList = costList;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
