package com.cdkj.loan.dto.req;

/**
 * 业绩完成情况统计
 * @author: jiafr 
 * @since: 2018年8月21日 上午11:35:53 
 * @history:
 */
public class XN630908Req extends APageReq {

    private static final long serialVersionUID = 4276641370382948570L;

    // 放款年份
    private String fkYear;

    // 业务公司
    private String companyCode;

    // 业务员
    private String saleUserId;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFkYear() {
        return fkYear;
    }

    public void setFkYear(String fkYear) {
        this.fkYear = fkYear;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

}
