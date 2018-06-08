package com.cdkj.loan.dto.req;

/**
 * 列表查询业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午3:38:21 
 * @history:
 */
public class XN630197Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
