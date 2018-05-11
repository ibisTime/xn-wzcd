package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EUserStatus;

public interface IUserBO extends IPaginableBO<User> {

    // C端用户注册
    public String doRegister(String mobile, String nickname, String loginPwd,
            String kind);

    // 车贷订单用户代注册实名认证
    public String doRegisterAndIdentify(String mobile, String idKind,
            String realName, String idNo);

    // 判断手机号是否存在
    public void isMobileExist(String mobile, String kind);

    // 判断昵称是否存在
    public void isNicknameExist(String nickname, String kind);

    // 更新手机号
    public int refreshMobile(String userId, String mobile);

    // 更新登录密码
    public int refreshLoginPwd(String userId, String loginPwd);

    // 更新交易密码
    public int refreshTradePwd(String userId, String tradePwd);

    // 更新昵称
    public void refreshNickname(String userId, String nickname);

    // 更新头像
    public void refreshPhoto(String userId, String photo);

    // 更新状态
    public void refreshStatus(String userId, EUserStatus normal, String updater,
            String remark);

    // 验证支付密码:拿tradePwd进行MD5后与数据库中userId得数据库支付密码比对
    public void checkTradePwd(String userId, String tradePwd);

    // 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库支付密码比对
    public void checkLoginPwd(String userId, String loginPwd);

    public List<User> queryUserList(User condition);

    public String getUserIdByMobile(String mobile);

    // 获取用户，不检查是否存在
    public User getUser(String mobile, String kind);

    // 获取UserId并检查是否存在
    public String getUserId(String mobile, String kind);

    public User getUser(String userId);

    public String saveUser(String mobile);

}
