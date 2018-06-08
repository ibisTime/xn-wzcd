package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除业务团队成员
 * @author: jiafr 
 * @since: 2018年6月8日 下午5:40:20 
 * @history:
 */
public class XN630201Req {

    @NotBlank(message = "编号不能为空")
    private String userId;

    private String updater;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
