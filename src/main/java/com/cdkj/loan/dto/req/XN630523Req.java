package com.cdkj.loan.dto.req;

public class XN630523Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String code;// 还款业务编号

    private String userId;// 用户编号

    private String loanBank;// 贷款银行

    private String curOverdueCount; // 现有逾期的次数

    private String curOverdueCountStart; // 现有逾期的次数起

    private String curOverdueCountEnd; // 现有逾期的次数止

    public String getCurOverdueCountStart() {
        return curOverdueCountStart;
    }

    public void setCurOverdueCountStart(String curOverdueCountStart) {
        this.curOverdueCountStart = curOverdueCountStart;
    }

    public String getCurOverdueCountEnd() {
        return curOverdueCountEnd;
    }

    public void setCurOverdueCountEnd(String curOverdueCountEnd) {
        this.curOverdueCountEnd = curOverdueCountEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getCurOverdueCount() {
        return curOverdueCount;
    }

    public void setCurOverdueCount(String curOverdueCount) {
        this.curOverdueCount = curOverdueCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
