package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 回退GPS设备申请
 * @author: jiafr 
 * @since: 2018年7月30日 下午2:37:34 
 * @history:
 */
public class XN632701Req {

    // GPS编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    // 回退原因（1GPS损坏2员工离职）
    @NotBlank
    private String reason;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
