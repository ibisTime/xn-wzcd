package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午11:22:33 
 * @history:
 */
public class XN632056Req {
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
