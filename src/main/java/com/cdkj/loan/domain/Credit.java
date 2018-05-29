package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 征信单
 * @author: jiafr 
 * @since: 2018年5月24日 下午9:26:48 
 * @history:
 */
public class Credit extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 贷款银行编号
    private String loanBankCode;

    // 贷款金额
    private Long loanAmount;

    // 业务种类 （新车 二手车）
    private String bizType;

    // 二手车评估报告
    private String secondCarReport;

    // 行驶证正面
    private String xszFront;

    // 行驶证反面
    private String xszReverse;

    // 预算单编号
    private String budgetCode;

    // 业务公司编号
    private String companyCode;

    // 业务员编号
    private String saleUserId;

    // 申请时间
    private Date applyDatetime;

    // 当前节点编号
    private String curNodeCode;

    // ****************db properties*******************

    // 申请时间起
    private Date applyDatetimeStart;

    // 申请时间止
    private Date applyDatetimeEnd;

    // 角色编号
    private String roleCode;

    // 业务公司
    private String companyName;

    // 贷款银行名称
    private String loanBankName;

    // 业务员
    private String saleUserName;

    // 征信人员（申请人）
    private CreditUser creditUser;

    // 征信人员信息
    private List<CreditUser> creditUserList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getSecondCarReport() {
        return secondCarReport;
    }

    public void setSecondCarReport(String secondCarReport) {
        this.secondCarReport = secondCarReport;
    }

    public String getXszFront() {
        return xszFront;
    }

    public void setXszFront(String xszFront) {
        this.xszFront = xszFront;
    }

    public String getXszReverse() {
        return xszReverse;
    }

    public void setXszReverse(String xszReverse) {
        this.xszReverse = xszReverse;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public CreditUser getCreditUser() {
        return creditUser;
    }

    public void setCreditUser(CreditUser creditUser) {
        this.creditUser = creditUser;
    }

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

}
