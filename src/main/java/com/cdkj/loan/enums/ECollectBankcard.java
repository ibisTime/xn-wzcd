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
 * 收款账号类型
 * @author: CYL 
 * @since: 2018年5月26日 下午5:17:07 
 * @history:
 */
public enum ECollectBankcard {
    PLATFORM("1", "平台"), FILIALE("2", "分公司");

    ECollectBankcard(String code, String value) {
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
