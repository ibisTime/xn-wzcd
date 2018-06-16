package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 申请解除
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630573Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 申请说明
    private String applyNote;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
