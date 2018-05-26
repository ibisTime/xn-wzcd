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
 * 部门状态
 * @author: CYL 
 * @since: 2018年5月22日 下午5:38:03 
 * @history:
 */
public enum EDepartmentType {
    DEPARTMENT("1", "部门"), POSITION("2", "职位");

    EDepartmentType(String code, String value) {
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
