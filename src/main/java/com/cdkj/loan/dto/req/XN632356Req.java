package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增公司结清记录
 * @author: CYL 
 * @since: 2018年8月24日 下午5:32:03 
 * @history:
 */
public class XN632356Req {

    // id
    @NotBlank(message = "结清记录id不能为空")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
