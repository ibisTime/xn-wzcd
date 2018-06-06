package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午11:38:53 
 * @history:
 */
public class XN632616Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
