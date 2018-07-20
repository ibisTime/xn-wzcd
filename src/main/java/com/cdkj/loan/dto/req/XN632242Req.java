package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 返点支付分公司总经理审批
 * @author: jiafr 
 * @since: 2018年7月20日 下午8:19:50 
 * @history:
 */
public class XN632242Req {

    // 审核说明
    @NotBlank
    private String approveNote;

    // 审核结果
    @NotBlank
    private String approveResult;

    // 返点编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

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

}
