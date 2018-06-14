package com.cdkj.loan.dto.req;

/**
 * 银行放款确认提交
 * @author: silver 
 * @since: 2018年6月13日 下午2:48:35 
 * @history:
 */
public class XN632140Req {

    // 预算单编号
    private String code;

    // 银行提交时间
    private String bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

    // 操作人
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
