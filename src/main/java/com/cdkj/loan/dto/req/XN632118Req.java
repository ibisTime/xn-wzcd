package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 查看征信报告
 * @author: jiafr 
 * @since: 2018年5月26日 下午10:21:23 
 * @history:
 */
public class XN632118Req {

    // 征信用户编号(必填)
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
