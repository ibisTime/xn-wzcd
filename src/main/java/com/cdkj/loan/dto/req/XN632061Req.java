/**
 * @Title XNlh5011Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午6:32:55 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 经销商协议下架
 * @author: jiafr 
 * @since: 2018年7月26日 下午9:37:17 
 * @history:
 */
public class XN632061Req {
    // 汽车经销商编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
