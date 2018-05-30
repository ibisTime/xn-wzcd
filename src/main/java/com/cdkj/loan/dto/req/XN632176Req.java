package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:52:02 
 * @history:
 */
public class XN632176Req {
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
