package com.cdkj.loan.dto.req;

/**
 * 分页查询团队成员
 * @author: jiafr 
 * @since: 2018年6月8日 下午5:59:44 
 * @history:
 */
public class XN630205Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 团队所属公司编号
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
