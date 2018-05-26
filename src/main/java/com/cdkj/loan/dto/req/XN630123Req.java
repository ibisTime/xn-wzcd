package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 上午10:59:40 
 * @history:
 */
public class XN630123Req {

    // 手机号(必填)
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    // 手机验证码(必填)
    @NotBlank(message = "手机验证不能为空")
    private String smsCaptcha;

    // 新登录密码(必填)
    @NotBlank(message = "新登录密码不能为空")
    private String newLoginPwd;

    // 类别(必填)
    @NotBlank
    private String type;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    public String getSmsCaptcha() {
        return smsCaptcha;
    }

    public void setSmsCaptcha(String smsCaptcha) {
        this.smsCaptcha = smsCaptcha;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
