package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630565Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 打款证明
    @NotBlank
    private String payAmountProve;

    // 操作人
    @NotBlank
    private String operator;

    // 备注
    private String remark;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getPayAmountProve() {
        return payAmountProve;
    }

    public void setPayAmountProve(String payAmountProve) {
        this.payAmountProve = payAmountProve;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
