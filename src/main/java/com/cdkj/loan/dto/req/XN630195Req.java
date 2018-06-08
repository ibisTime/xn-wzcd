package com.cdkj.loan.dto.req;

/**
 * 分页查询业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:29:29 
 * @history:
 */
public class XN630195Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
