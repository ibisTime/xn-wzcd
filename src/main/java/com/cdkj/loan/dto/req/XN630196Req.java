package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 业务团队详情
 * @author: jiafr 
 * @since: 2018年6月8日 下午3:24:33 
 * @history:
 */
public class XN630196Req {

    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
