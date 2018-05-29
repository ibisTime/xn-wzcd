package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-抵押确认提交银行
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632132Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 抵押提交银行时间
    private String pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

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

    public String getPledgeBankCommitDatetime() {
        return pledgeBankCommitDatetime;
    }

    public void setPledgeBankCommitDatetime(String pledgeBankCommitDatetime) {
        this.pledgeBankCommitDatetime = pledgeBankCommitDatetime;
    }

    public String getPledgeBankCommitNote() {
        return pledgeBankCommitNote;
    }

    public void setPledgeBankCommitNote(String pledgeBankCommitNote) {
        this.pledgeBankCommitNote = pledgeBankCommitNote;
    }
}
