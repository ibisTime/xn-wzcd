package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代偿预算单详细查
 * @author: silver 
 * @since: 2018年6月15日 上午11:15:02 
 * @history:
 */
public class XN632326Req {
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
