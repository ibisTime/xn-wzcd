package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CUser;

public interface ICUserAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    // 检查手机号是否存在
    // public void doCheckMobile(String mobile);

    // 验证码注册用户
    public String doCaptchaLoginReg(String mobile, String smsCaptcha);

    // 用户登录
    public String doLogin(String loginName, String loginPwd);

    // 检查登录密码是否正确
    public void doCheckLoginPwd(String userId, String loginPwd);

    // 注册
    public String insertCUser(CUser data);

    // 分页查询
    public Paginable<CUser> queryCUserPage(int start, int limit,
            CUser condition);

    // 列表查询
    public List<CUser> queryCUserList(CUser condition);

    // 详情查询
    public CUser getCUser(String userId);

}
