package com.cdkj.loan.dto.req;

/**
 * 车贷档案分页查
 * @author: silver 
 * @since: 2018年6月13日 下午2:56:47 
 * @history:
 */
public class XN632195Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 业务编号
    private String code;

    // 客户姓名
    private String customerName;

    // 贷款银行
    private String loanBankCode;

    // 业务员
    private String saleUserId;

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

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }
}
