package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:34:07 
 * @history:
 */
public class XN632026Req {
    // 序号
    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
