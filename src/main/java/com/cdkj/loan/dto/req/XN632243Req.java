package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 返点支付财务确认
 * @author: jiafr 
 * @since: 2018年7月20日 下午8:19:50 
 * @history:
 */
public class XN632243Req {

    // 返点编号
    @NotBlank
    private String code;

    // 财务审核说明
    @NotBlank
    private String approveNote;

    // 财务审核结果
    @NotBlank
    private String approveResult;

    // 操作人
    @NotBlank
    private String operator;

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

}
