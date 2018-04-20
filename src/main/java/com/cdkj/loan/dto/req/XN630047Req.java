/**
 * @Title XNlh5034Req.java 
 * @Package com.cdkj.ylq.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年6月12日 下午1:36:37 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: haiqingzheng 
 * @since: 2016年6月12日 下午1:36:37 
 * @history:
 */
public class XN630047Req {

    // key(必填)
    @NotBlank(message = "key不能为空")
    private String key;

    // 公司编号(必填)
    @NotBlank(message = "公司编号不能为空")
    private String companyCode;

    // 系统编号(必填)
    @NotBlank(message = "系统编号不能为空")
    private String systemCode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
