package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午8:33:07 
 * @history:
 */
public class XN632801Req {

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
