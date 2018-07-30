package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 重新申请执行
 * @author: CYL 
 * @since: 2018年7月30日 上午10:26:09 
 * @history:
 */
public class XN630561Req {
    // 编号
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
