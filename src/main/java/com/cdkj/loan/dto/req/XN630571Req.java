package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 审核
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630571Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 审核说明
    private String approveNote;

    // 审核结果 1=通过 0=不通过
    @NotBlank
    private String approveResult;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
