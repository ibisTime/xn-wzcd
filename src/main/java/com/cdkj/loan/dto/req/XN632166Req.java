package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 手续费详情
 * @author: xieyj 
 * @since: 2018年5月30日 下午7:24:06 
 * @history:
 */
public class XN632166Req {

    // 手续费编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
