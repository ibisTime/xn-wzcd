/**
 * @Title XN625100Req.java 
 * @Package com.cdkj.coin.dto.req 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月9日 下午7:02:19 
 * @version V1.0   
 */
package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月9日 下午7:02:19 
 * @history:
 */
public class XN625100Req {

    @NotBlank
    private String address;// 地址

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
