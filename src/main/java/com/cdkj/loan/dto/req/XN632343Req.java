package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * gps 回收作废
 * @author: silver 
 * @since: 2018年6月18日 下午5:51:55 
 * @history:
 */
public class XN632343Req {
    // 编号
    @NotBlank
    private String code;

    // 备注
    private String remark;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
