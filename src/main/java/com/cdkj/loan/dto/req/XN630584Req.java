package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630584Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 查封裁定到期时间
    @NotBlank
    private String AdjudicationDeadline;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getAdjudicationDeadline() {
        return AdjudicationDeadline;
    }

    public void setAdjudicationDeadline(String adjudicationDeadline) {
        AdjudicationDeadline = adjudicationDeadline;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
