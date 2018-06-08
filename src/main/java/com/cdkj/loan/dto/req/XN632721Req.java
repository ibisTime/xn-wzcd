package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 阅读公告
 * @author: silver 
 * @since: 2018年6月7日 下午5:58:05 
 * @history:
 */
public class XN632721Req {
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
