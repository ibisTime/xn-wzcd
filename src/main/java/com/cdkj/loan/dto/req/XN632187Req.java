package com.cdkj.loan.dto.req;

/**
 * 分页查询垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午9:14:13 
 * @history:
 */
public class XN632187Req extends APageReq {

    private static final long serialVersionUID = -6854132522148511455L;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 贷款银行编号
    private String loanBankCode;

    // 申请日期起
    private String applyDatetimeStart;

    // 申请日期止
    private String applyDatetimeEnd;

    // 节点编号
    private String curNodeCode;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
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

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

}
