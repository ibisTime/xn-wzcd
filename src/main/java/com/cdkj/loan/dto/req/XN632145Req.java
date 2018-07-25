package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 银行放款分页查
 * @author: silver 
 * @since: 2018年6月13日 下午2:56:47 
 * @history:
 */
public class XN632145Req extends APageReq {

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

    private String enterFileStatus;// 入档状态（0待入档1待补录2已入档）

    private String isSubmitCancel;// 是否提交作废申请

    private String backAdvanceFundPage;// 收回垫资款页页面分页查询标识

    public String getBackAdvanceFundPage() {
        return backAdvanceFundPage;
    }

    public void setBackAdvanceFundPage(String backAdvanceFundPage) {
        this.backAdvanceFundPage = backAdvanceFundPage;
    }

    public String getIsSubmitCancel() {
        return isSubmitCancel;
    }

    public void setIsSubmitCancel(String isSubmitCancel) {
        this.isSubmitCancel = isSubmitCancel;
    }

    public String getCarDealerCode() {
        return carDealerCode;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getEnterFileStatus() {
        return enterFileStatus;
    }

    public void setEnterFileStatus(String enterFileStatus) {
        this.enterFileStatus = enterFileStatus;
    }

}
