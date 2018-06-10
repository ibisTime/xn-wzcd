package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 客户作废详情查询
 * @author: jiafr 
 * @since: 2018年6月10日 下午10:31:03 
 * @history:
 */
public class XN632196Req {

    // 角色编号(必填)
    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
