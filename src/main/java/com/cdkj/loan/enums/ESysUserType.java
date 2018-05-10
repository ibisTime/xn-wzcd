/**
 * @Title ECheckResult.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:58:54 
 * @version V1.0   
 */
package com.cdkj.loan.enums;

/**
 * 用户类型
 * @author: CYL 
 * @since: 2018年5月10日 下午2:38:37 
 * @history:
 */
public enum ESysUserType {
    Plat("P", "平台用户");

    ESysUserType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
