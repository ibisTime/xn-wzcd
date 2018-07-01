package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.User;

public interface IUserAO {

    String DEFAULT_ORDER_COLUMN = "user_id";

    // C端用户注册
    public String doRegister(String mobile, String nickname, String loginPwd,
            String smsCaptcha, String kind);

    // 验证码注册用户
    public String doCaptchaLoginReg(String mobile, String smsCaptcha,
            String loginPwd, String confirmPwd);

    // 用户登录
    public String doLogin(String loginName, String loginPwd, String kind);

    // 更换手机号
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha);

    // 重置登录密码
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String kind);

    // 修改登录密码
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd);

    // 设置支付密码
    public void doSetTradePwd(String userId, String tradePwd, String smsCaptcha);

    // 重置支付密码
    public void doResetTradePwd(String userId, String newTradePwd,
            String smsCaptcha);

    // 修改支付密码
    public void doModifyTradePwd(String userId, String oldTradePwd,
            String newTradePwd);

    // 修改头像
    public void modifyPhoto(String userId, String photo);

    // 修改昵称
    public void modifyNickname(String userId, String nickname);

    // 注销/激活用户
    public void doCloseOpen(String userId, String updater, String remark);

    // 分页查询
    public Paginable<User> queryUserPage(int start, int limit, User condition);

    // 列表查询
    public List<User> queryUserList(User condition);

    // 详情查询
    public User getUser(String userId);

}
