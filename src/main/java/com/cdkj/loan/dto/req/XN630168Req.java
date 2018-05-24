package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月24日 上午11:57:53 
 * @history:
 */
public class XN630168Req {

    @NotBlank
    private String roleCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
