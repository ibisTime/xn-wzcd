/**
 * @Title XN630530Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2018年5月6日 下午5:49:16 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: haiqingzheng 
 * @since: 2018年5月6日 下午5:49:16 
 * @history:
 */
public class XN630530Req {

    @NotBlank
    private String code;// 还款计划编号（必填

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
