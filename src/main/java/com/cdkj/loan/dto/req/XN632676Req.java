package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询费用预支订单
 * @author: xieyj 
 * @since: 2018年6月6日 下午9:22:30 
 * @history:
 */
public class XN632676Req {

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
