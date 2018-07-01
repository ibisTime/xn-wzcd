package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.User;

public interface IUserDAO extends IBaseDAO<User> {

    String NAMESPACE = IUserDAO.class.getName().concat(".");

    // 设置支付密码
    public int updateTradePwd(User data);

    // 设置登录密码
    public int updateLoginPwd(User data);

    // 更新手机号
    public int updateMobile(User data);

    // 更新昵称
    public int updateNickname(User data);

    // 更新头像
    public int updatePhoto(User data);

    // 更新状态
    public int updateStatus(User data);

    // 更新绿名单标记
    public int updateGreenSign(User data);

    // 更新黄名单标记
    public int updateYellowSign(User data);

    // 更新红名单标记
    public int updateRedSign(User data);

}
