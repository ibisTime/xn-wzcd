package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 客户申请作废
 * @author: jiafr 
 * @since: 2018年6月10日 下午7:25:37 
 * @history:
 */
public class XN632190Req {

    // 准入单编号
    @NotBlank
    private String code;

    // 作废原因
    @NotBlank
    private String remark;

    // 操作人
    @NotBlank
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

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

}
