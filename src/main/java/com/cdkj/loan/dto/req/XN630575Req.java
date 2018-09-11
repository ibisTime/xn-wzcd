package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 风控主管审核
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630575Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 审核结果 1=通过 0=不通过
    @NotBlank
    private String approveResult;

    // 申请说明
    @NotBlank
    private String approveNote;

    @NotBlank
    private String operator;

    private String remark;

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

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getOperator() {
        return operator;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
