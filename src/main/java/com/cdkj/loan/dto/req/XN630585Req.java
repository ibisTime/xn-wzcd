package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 风控主管审核
 * @author: CYL 
 * @since: 2018年8月28日 下午5:31:08 
 * @history:
 */
public class XN630585Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 审核结果 1=通过 0=不通过
    @NotBlank
    private String approveResult;

    // 申请说明
    @NotBlank
    private String applyNote;

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

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
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
