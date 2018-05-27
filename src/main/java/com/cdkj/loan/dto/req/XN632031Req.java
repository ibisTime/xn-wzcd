package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:46:11 
 * @history:
 */
public class XN632031Req {
    // 银行编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
