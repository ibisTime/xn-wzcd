package com.cdkj.loan.domain;

import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 征信人员
 * @author: jiafr 
 * @since: 2018年5月24日 下午9:32:23 
 * @history:
 */
public class CreditUser extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 征信单编号
    private String creditCode;

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

    // 银行征信结果
    private String bankCreditResultPdf;

    // 征信人员列表
    private List<CreditUser> creditUserList;

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getBankCreditResultPdf() {
        return bankCreditResultPdf;
    }

    public void setBankCreditResultPdf(String bankCreditResultPdf) {
        this.bankCreditResultPdf = bankCreditResultPdf;
    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
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

    /*
     * // 月收入 private Long monthIncome; // 结息 private Double settleInterest; //
     * 余额 private Long balance; // 流水是否体现月收入 private String jourShowIncome; //
     * 是否打件 private String isPrint;
     */

}
