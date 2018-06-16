package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代偿审核详细查
 * @author: silver 
 * @since: 2018年6月16日 上午10:23:17 
 * @history:
 */
public class XN632337Req {
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
