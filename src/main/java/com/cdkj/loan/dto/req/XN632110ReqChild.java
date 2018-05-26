package com.cdkj.loan.dto.req;

/**
 * 征信新增 （征信人员）
 * @author: jiafr 
 * @since: 2018年5月25日 下午10:23:09 
 * @history:
 */
public class XN632110ReqChild {

    // 姓名
    private String userName;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 手机号
    private String mobile;

    // 身份证号
    private String idNo;

    // 身份证正面
    private String idNoFront;

    // 身份证反面
    private String idNoReverse;

    // 征信查询授权书
    private String authPdf;

    // 面签照片
    private String interviewPic;

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

}
