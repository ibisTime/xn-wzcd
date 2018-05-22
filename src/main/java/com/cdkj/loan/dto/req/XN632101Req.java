package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632101Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    @NotBlank
    private String approveResult;// 审核结果

    private String financeCheckNote;// 财务审核说明

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

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getFinanceCheckNote() {
        return financeCheckNote;
    }

    public void setFinanceCheckNote(String financeCheckNote) {
        this.financeCheckNote = financeCheckNote;
    }

}
