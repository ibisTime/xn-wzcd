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
 * 日志状态
 * @author: CYL 
 * @since: 2018年5月25日 上午12:50:57 
 * @history:
 */
public enum ESYSBizLogStatus {
    WAIT_HANDLE("0", "待处理"), ALREADY_HANDLE("1", "已处理");

    ESYSBizLogStatus(String code, String value) {
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
