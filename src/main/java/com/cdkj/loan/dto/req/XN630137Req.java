package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 上午11:01:02 
 * @history:
 */
public class XN630137Req {

    // （必填） 关键字
    @NotBlank(message = "用户Id不能为空")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
