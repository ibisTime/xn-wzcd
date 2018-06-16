package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认用款单
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:24:45 
 * @history:
 */
public class XN632170Req {

    // 垫资单编号
    @NotBlank
    private String code;

    // 是否垫资
    @NotBlank
    private String isAdvanceFund;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
