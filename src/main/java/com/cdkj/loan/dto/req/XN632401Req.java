package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除奖金提成配置
 * @author: CYL 
 * @since: 2018年8月20日 下午7:17:00 
 * @history:
 */
public class XN632401Req {

    // id
    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
