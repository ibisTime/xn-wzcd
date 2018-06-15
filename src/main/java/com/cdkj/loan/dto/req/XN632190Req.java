package com.cdkj.loan.dto.req;

/**
 * 车辆抵押确认提交银行
 * @author: silver 
 * @since: 2018年6月13日 下午2:48:35 
 * @history:
 */
public class XN632190Req {

    // 预算单编号
    private String code;

    // 抵押提交时间
    private String pledgeCommitDatetime;

    // 抵押提交说明
    private String pledgeCommitNote;

    // 操作人
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPledgeCommitDatetime() {
        return pledgeCommitDatetime;
    }

    public void setPledgeCommitDatetime(String pledgeCommitDatetime) {
        this.pledgeCommitDatetime = pledgeCommitDatetime;
    }

    public String getPledgeCommitNote() {
        return pledgeCommitNote;
    }

    public void setPledgeCommitNote(String pledgeCommitNote) {
        this.pledgeCommitNote = pledgeCommitNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
