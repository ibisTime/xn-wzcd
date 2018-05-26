package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 上午11:00:17 
 * @history:
 */
public class XN630126Req {

    // 用户编号(必填)
    @NotBlank(message = "不能为空")
    private String userId;

    // 更新人(必填)
    @NotBlank(message = "不能为空")
    private String updater;

    // 备注(选填)
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
