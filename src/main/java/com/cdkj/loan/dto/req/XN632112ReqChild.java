package com.cdkj.loan.dto.req;

public class XN632112ReqChild {

    // 征信人员编号
    private String creditUserCode;

    // 姓名
    private String userName;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 身份证号
    private String idNo;

    // 手机号
    private String mobile;

    // 身份证正面
    private String idNoFront;

    // 身份证反面
    private String idNoReverse;

    // 征信查询授权书
    private String authPdf;

    // 面签照片
    private String interviewPic;

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLoanRole() {
        return loanRole;
    }

    public void setLoanRole(String loanRole) {
        this.loanRole = loanRole;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNoFront() {
        return idNoFront;
    }

    public void setIdNoFront(String idNoFront) {
        this.idNoFront = idNoFront;
    }

    public String getIdNoReverse() {
        return idNoReverse;
    }

    public void setIdNoReverse(String idNoReverse) {
        this.idNoReverse = idNoReverse;
    }

    public String getAuthPdf() {
        return authPdf;
    }

    public void setAuthPdf(String authPdf) {
        this.authPdf = authPdf;
    }

    public String getInterviewPic() {
        return interviewPic;
    }

    public void setInterviewPic(String interviewPic) {
        this.interviewPic = interviewPic;
    }

}
