package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:06:20 
 * @history:
 */
public class XN630191Req {

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
