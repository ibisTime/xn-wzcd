package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询补签
 * @author: silver 
 * @since: 2018年6月6日 下午12:36:41 
 * @history:
 */
public class XN632606Req {
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
