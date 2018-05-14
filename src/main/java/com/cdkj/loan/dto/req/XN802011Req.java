package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: asus 
 * @since: 2016年12月22日 下午5:51:56 
 * @history:
 */
public class XN802011Req {

    // 编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
