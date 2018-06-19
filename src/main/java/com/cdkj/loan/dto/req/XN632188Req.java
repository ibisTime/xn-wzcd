package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 分页查询垫资
 * @author: jiafr 
 * @since: 2018年6月18日 上午1:56:04 
 * @history:
 */
public class XN632188Req {

    // 业务公司编号
    @NotBlank
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
