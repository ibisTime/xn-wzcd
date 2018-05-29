package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-确认提交银行
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632129Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 提交银行时间
    private String bankCommitDatetime;

    // 提交说明
    private String bankCommitNote;

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

    public String getBankCommitDatetime() {
        return bankCommitDatetime;
    }

    public void setBankCommitDatetime(String bankCommitDatetime) {
        this.bankCommitDatetime = bankCommitDatetime;
    }

    public String getBankCommitNote() {
        return bankCommitNote;
    }

    public void setBankCommitNote(String bankCommitNote) {
        this.bankCommitNote = bankCommitNote;
    }
}
