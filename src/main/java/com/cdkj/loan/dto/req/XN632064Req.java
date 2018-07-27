package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 汽车经销商协议上架
 * @author: jiafr 
 * @since: 2018年7月26日 下午9:43:42 
 * @history:
 */
public class XN632064Req {

    // 汽车经销商编号
    @NotBlank
    private String code;

    // 操作人
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
