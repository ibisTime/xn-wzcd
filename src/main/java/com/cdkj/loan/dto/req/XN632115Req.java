package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信分页查询 （按角色权限）
 * @author: jiafr 
 * @since: 2018年5月26日 上午10:18:51 
 * @history:
 */
public class XN632115Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 申请日期开始
    private String applyDatetimeStart;

    // 申请日期结束
    private String applyDatetimeEnd;

    // 贷款银行
    private String loanBankCode;

    // 客户姓名
    private String userName;

    // 业务员
    private String saleUserId;

    // 征信单编号
    private String code;

    // 业务公司编号
    private String companyCode;

    // 角色编号
    private String roleCode;

    // 节点
    private String curNodeCode;

    private List<String> curNodeCodeList;// 节点

    // 当前登录人的公司编号
    @NotBlank
    private String currentUserCompanyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCurrentUserCompanyCode() {
        return currentUserCompanyCode;
    }

    public void setCurrentUserCompanyCode(String currentUserCompanyCode) {
        this.currentUserCompanyCode = currentUserCompanyCode;
    }

}
