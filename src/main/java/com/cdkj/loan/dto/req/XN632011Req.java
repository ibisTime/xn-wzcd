package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:34:07 
 * @history:
 */
public class XN632011Req {
    // 区域序号
    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
