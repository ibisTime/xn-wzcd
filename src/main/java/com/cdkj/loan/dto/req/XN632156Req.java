package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询资料传递
 * @author: silver 
 * @since: 2018年5月30日 下午5:13:17 
 * @history:
 */
public class XN632156Req {
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
