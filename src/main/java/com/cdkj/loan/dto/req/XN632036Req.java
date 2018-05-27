package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午5:40:28 
 * @history:
 */
public class XN632036Req {
    // 序号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
