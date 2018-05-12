package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 查询充值订单详情
 * @author: xieyj 
 * @since: 2017年5月12日 上午10:00:44 
 * @history:
 */
public class XN802706Req {

    // 订单编号（必填）
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
