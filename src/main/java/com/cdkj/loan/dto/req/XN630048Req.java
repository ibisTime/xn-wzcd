package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午3:58:52 
 * @history:
 */
public class XN630048Req {
    // 配置类型（必填）
    @NotBlank(message = "配置类型不能为空")
    private String type;

    // 公司编号（必填）
    @NotBlank(message = "公司编号不能为空")
    private String companyCode;

    // 系统编号（必填）
    @NotBlank(message = "系统编号不能为空")
    private String systemCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
