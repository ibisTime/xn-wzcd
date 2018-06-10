package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询退客户垫资款
 * @author: jiafr 
 * @since: 2018年6月9日 下午10:45:38 
 * @history:
 */
public class XN632186Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
