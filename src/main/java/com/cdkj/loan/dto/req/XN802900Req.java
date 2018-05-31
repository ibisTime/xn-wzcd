/**
 * @Title XN802900Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2018年6月1日 上午4:35:58 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: haiqingzheng 
 * @since: 2018年6月1日 上午4:35:58 
 * @history:
 */
public class XN802900Req {

    @NotBlank
    private String userId; // 用户编号

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
