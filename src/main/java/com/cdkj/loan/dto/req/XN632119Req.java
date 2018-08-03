package com.cdkj.loan.dto.req;

public class XN632119Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -3823911654028555352L;

    private String code;// 编号

    private String creditCode;// 征信单编号

    private String loanRole;// 贷款角色

    private String isFirstAudit;// 是否一审

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getLoanRole() {
        return loanRole;
    }

    public void setLoanRole(String loanRole) {
        this.loanRole = loanRole;
    }

    public String getIsFirstAudit() {
        return isFirstAudit;
    }

    public void setIsFirstAudit(String isFirstAudit) {
        this.isFirstAudit = isFirstAudit;
    }

}
