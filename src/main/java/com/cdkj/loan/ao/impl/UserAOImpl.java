package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630200Req;
import com.cdkj.loan.enums.EUserStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class UserAOImpl implements IUserAO {

    @Autowired
    private IUserBO userBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    public XN630200Req doRegister(String mobile, String loginPwd,
            String smsCaptcha) {
        String userId = userBO.doRegister(mobile, loginPwd, smsCaptcha);
        return new XN630200Req(userId);
    }

    // 验证手机号

    @Override
    public void doCheckMobile(String mobile) {
        // userBO.isMobileExist(mobile);
    }

    @Override
    public String doCaptchaLoginReg(String mobile, String smsCaptcha,
            String loginPwd, String confirmPwd) {
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "630080");
        String userId = userBO.getUserIdByMobile(mobile);
        if (StringUtils.isNotBlank(userId)) {
            throw new BizException("mag", "手机号已存在，请重新输入！！！");
        }
        if (!loginPwd.equals(confirmPwd)) {
            throw new BizException("mag", "两次密码不一致，请重新输入！！！");
        }
        userId = userBO.saveUser(mobile);
        return userId;
    }

    // 用户登录
    @Override
    @Transactional
    public String doLogin(String loginName, String loginPwd) {
        User condition = new User();
        // if (EUserKind.Customer.getCode().equals(kind)
        // || EUserKind.Merchant.getCode().equals(kind)) {
        // condition.setLoginName(loginName);
        // condition.setLoginType(ELoginType.MOBILE.getCode());
        // } else {
        condition.setLoginName(loginName);
        // }
        List<User> userList1 = userBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList1)) {
            throw new BizException("xn805050", "登录名不存在");
        }
        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<User> userList2 = userBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList2)) {
            throw new BizException("xn805050", "登录密码错误");
        }
        User user = userList2.get(0);
        if (!EUserStatus.NORMAL.getCode().equals(user.getStatus())) {
            throw new BizException("xn805050",
                "该账号" + EUserStatus.getMap().get(user.getStatus()).getValue()
                        + "，请联系工作人员");
        }
        // addLoginAmount(user);
        // userBO.refreshLastLogin(user.getUserId());
        return user.getUserId();
    }

    // 登录名密码验证
    // @Override
    // public void doCheckLoginPwd(String loginName, String loginPwd) {
    // User condition = new User();
    // condition.setLoginName(loginName);
    // List<User> userList1 = userBO.queryUserList(condition);
    // if (CollectionUtils.isEmpty(userList1)) {
    // throw new BizException("xn702002", "用户不存在");
    // }
    // condition.setLoginPwd(MD5Util.md5(loginPwd));
    // List<User> userList2 = userBO.queryUserList(condition);
    // if (CollectionUtils.isEmpty(userList2)) {
    // throw new BizException("xn702002", "登录密码错误");
    // }
    //
    // }

    @Override
    public String insertUser(User data) {
        return userBO.saveCNavigate(data);
    }

    @Override
    public Paginable<User> queryUserPage(int start, int limit, User condition) {
        return userBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<User> queryUserList(User condition) {
        return userBO.queryUserList(condition);
    }

    @Override
    public User getUser(String userId) {
        return userBO.getUser(userId);
    }

}
