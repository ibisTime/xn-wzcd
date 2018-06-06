package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询出差申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午2:43:24 
 * @history:
 */
public class XN632626Req {

    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
