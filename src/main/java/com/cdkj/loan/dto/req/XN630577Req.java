package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 抵押解除确认
 * @author: xieyj 
 * @since: 2018年6月30日 下午7:53:38 
 * @history:
 */
public class XN630577Req {
    // 还款业务编号
    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
