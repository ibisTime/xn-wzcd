package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:34:07 
 * @history:
 */
public class XN632021Req {
    // 省份序号
    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
