package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询出库
 * @author: silver 
 * @since: 2018年6月5日 下午2:49:43 
 * @history:
 */
public class XN632776Req {
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
