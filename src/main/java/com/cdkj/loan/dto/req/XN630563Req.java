package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630563Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String approveResult;// 审核结果

    @NotBlank
    private String suggest;// 建议

    private String suggestNote;// 建议说明

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getSuggestNote() {
        return suggestNote;
    }

    public void setSuggestNote(String suggestNote) {
        this.suggestNote = suggestNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
