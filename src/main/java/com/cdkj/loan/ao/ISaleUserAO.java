package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SaleUser;

public interface ISaleUserAO {

    String DEFAULT_ORDER_COLUMN = "user_id";

    // 业务员注册
    public String doRegister(String mobile, String loginPwd, String type);

    // 验证码注册业务员
    public String doCaptchaLoginReg(String mobile, String smsCaptcha,
            String loginPwd, String confirmPwd);

    // 业务员登录
    public String doLogin(String loginName, String loginPwd, String type);

    // 更换手机号
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha);

    // 设置角色
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark);

    // 设置部门
    public void doDepartment(String userId, String departmentCode,
            String updater, String remark);

    // 重置登录密码
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String type);

    // 修改登录密码
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd);

    // 修改头像
    public void modifyPhoto(String userId, String photo);

    // 注销/激活业务员
    public void doCloseOpen(String userId, String updater, String remark);

    // 分页查询
    public Paginable<SaleUser> querySaleUserPage(int start, int limit,
            SaleUser condition);

    // 列表查询
    public List<SaleUser> querySaleUserList(SaleUser condition);

    // 详情查询
    public SaleUser getSaleUser(String userId);

    // 管理员重置登录密码
    void doResetLoginPwdByOss(String userId, String loginPwd, String udpater,
            String remark);

}
