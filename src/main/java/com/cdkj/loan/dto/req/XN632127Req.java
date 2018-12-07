package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信查询请求接口
 * @author: CYL 
 * @since: 2018年11月30日 下午4:32:37 
 * @history:
 */
public class XN632127Req {
    @NotBlank
    private String code;// 征信人员编号

    @NotBlank
    private String systemCode;

    @NotBlank
    private String companyCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
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

}
