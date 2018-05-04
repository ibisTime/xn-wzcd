package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CUser;

public interface ICUserBO extends IPaginableBO<CUser> {

    // C端用户注册
    public String doRegister(String mobile, String loginPwd, String smsCaptcha);

    // 车贷订单用户代注册实名认证
    public String doRegisterAndIdentify(String mobile, String idKind,
            String realName, String idNo);

    // 判断手机号是否存在
    // public void isMobileExist(String mobile);

    // 判断昵称是否存在
    // public void isNicknameExist(String nickname);

    // 判断登录名是否存在
    // public void isLoginNameExist(String loginName);

    // 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库支付密码比对
    // public void checkLoginPwd(String userId, String loginPwd);

    // 判断推荐人是否存在(手机号)
    // public void checkUserReferee(String userReferee, String systemCode);

    public List<CUser> queryUserList(CUser condition);

    public String getUserId(String mobile);

    public CUser getUser(String userId);

    public String saveUser(String mobile);

    public String saveCNavigate(CUser data);

    public CUser getUserById(String userId);

}
