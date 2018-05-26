package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 上午11:00:06 
 * @history:
 */
public class XN630125Req {

    // 用户编号(必填)
    @NotBlank(message = "用户编号不能为空")
    private String userId;

    // 登录密码(必填)
    @NotBlank(message = "新登录密码不能为空")
    private String loginPwd;

    // 更新人(必填)
    @NotBlank(message = "用户编号不能为空")
    private String updater;

    // 备注(必填)
    private String remark;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

}
