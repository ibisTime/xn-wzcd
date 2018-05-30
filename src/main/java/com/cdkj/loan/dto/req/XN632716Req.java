package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询GPS申领信息
 * @author: silver 
 * @since: 2018年5月31日 上午2:34:18 
 * @history:
 */
public class XN632716Req {
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
