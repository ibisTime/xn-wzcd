package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN632148Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String code;// 业务编号

    private String customerName;// 客户姓名

    private String applyDatetimeStart;// 申请时间起始

    private String applyDatetimeEnd;// 申请时间结束

    private String saleUserId;// 业务员用户编号

    private String curNodeCode;// 当前节点编号

    private String carDealerCode;// 汽车经销商

    private String loanBankCode;// 贷款银行

    private String companyCode;// 业务公司

    private String isAdvanceFund;// 是否垫资

    private List<String> curNodeCodeList;// 节点

    private List<String> pledgeCurNodeCodeList;// 抵押流程节点编号

    // 是否提交作废申请
    private String isSubmitCancel;

    @NotBlank
    private String roleCode;// 角色编号

    // 入档状态List
    private List<String> enterFileStatusList;

    public List<String> getEnterFileStatusList() {
        return enterFileStatusList;
    }

    public void setEnterFileStatusList(List<String> enterFileStatusList) {
        this.enterFileStatusList = enterFileStatusList;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public String getIsSubmitCancel() {
        return isSubmitCancel;
    }

    public List<String> getPledgeCurNodeCodeList() {
        return pledgeCurNodeCodeList;
    }

    public void setPledgeCurNodeCodeList(List<String> pledgeCurNodeCodeList) {
        this.pledgeCurNodeCodeList = pledgeCurNodeCodeList;
    }

    public void setIsSubmitCancel(String isSubmitCancel) {
        this.isSubmitCancel = isSubmitCancel;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
