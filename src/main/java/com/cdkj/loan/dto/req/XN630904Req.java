package com.cdkj.loan.dto.req;

/**
 * 逾期客户清收进度表
 * @author: jiafr 
 * @since: 2018年8月21日 上午11:37:21 
 * @history:
 */
public class XN630904Req extends APageReq {

    private static final long serialVersionUID = -6263583306083692342L;

    private String code;// 还款业务

    private String realName;// 客户姓名

    private String loanBankCode;// 贷款银行

    private String companyCode;// 业务公司

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

}
