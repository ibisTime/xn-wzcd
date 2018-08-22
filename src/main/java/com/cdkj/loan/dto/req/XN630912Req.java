package com.cdkj.loan.dto.req;

/**
 * 奖金提成
 * @author: jiafr 
 * @since: 2018年8月22日 下午5:56:20 
 * @history:
 */
public class XN630912Req extends APageReq {

    private static final long serialVersionUID = -6252658967187686575L;

    // 业务公司编号
    private String companyCode;

    // 放款月份起
    private String fkMonthStart;

    // 放款月份止
    private String fkMonthEnd;

    // 业务员编号
    private String saleUserId;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFkMonthStart() {
        return fkMonthStart;
    }

    public void setFkMonthStart(String fkMonthStart) {
        this.fkMonthStart = fkMonthStart;
    }

    public String getFkMonthEnd() {
        return fkMonthEnd;
    }

    public void setFkMonthEnd(String fkMonthEnd) {
        this.fkMonthEnd = fkMonthEnd;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

}
