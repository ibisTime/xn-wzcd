package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 续保短信发送
 * @author: silver 
 * @since: 2018年6月18日 上午11:13:16 
 * @history:
 */
public class XN632340Req {
    // 预算单编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
