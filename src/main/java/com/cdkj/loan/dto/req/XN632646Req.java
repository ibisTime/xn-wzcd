package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询办公用品申请
 * @author: jiafr 
 * @since: 2018年6月7日 上午11:42:58 
 * @history:
 */
public class XN632646Req {

    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
