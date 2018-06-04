package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询离职档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:28:29 
 * @history:
 */
public class XN632816Req {

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
