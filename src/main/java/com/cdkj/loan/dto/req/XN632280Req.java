package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 发起收回垫资款申请
 * @author: jiafr 
 * @since: 2018年8月4日 下午7:42:53 
 * @history:
 */
public class XN632280Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 收回垫资款类型(1、客户作废2、垫资款退回)
    @NotBlank
    private String type;

    // 作废原因
    @NotBlank
    private String zfReason;

    // 收款金额
    @NotBlank
    private String zfSkAmount;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZfReason() {
        return zfReason;
    }

    public void setZfReason(String zfReason) {
        this.zfReason = zfReason;
    }

    public String getZfSkAmount() {
        return zfSkAmount;
    }

    public void setZfSkAmount(String zfSkAmount) {
        this.zfSkAmount = zfSkAmount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
