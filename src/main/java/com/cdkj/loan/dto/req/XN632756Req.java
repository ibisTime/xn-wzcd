package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:21:15 
 * @history:
 */
public class XN632756Req {
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
