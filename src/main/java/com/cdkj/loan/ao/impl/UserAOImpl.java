package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.ECaptchaType;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EUserStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class UserAOImpl implements IUserAO {

    @Autowired
    private IUserBO userBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IAccountBO accountBO;

    @Override
    @Transactional
    public String doRegister(String mobile, String nickname, String loginPwd,
            String smsCaptcha, String kind) {

        // 验证手机号是否存在
        userBO.isMobileExist(mobile, kind);

        // 检查昵称是否已经被使用
        userBO.isNicknameExist(nickname, kind);

        // 验证短信验证码
        smsOutBO.checkCaptcha(mobile, smsCaptcha, ECaptchaType.C_REG.getCode());

        // 注册用户
        String userId = userBO.doRegister(mobile, nickname, loginPwd, kind);

        // 分配账户
        distributeAccount(userId, mobile, kind);

        return userId;
    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind) {

        List<String> currencyList = new ArrayList<String>();
        currencyList.add(ECurrency.CNY.getCode());
        currencyList.add(ECurrency.JF.getCode());
        currencyList.add(ECurrency.XYF.getCode());

        for (String currency : currencyList) {
            accountBO.distributeAccount(userId, mobile,
                EAccountType.getAccountType(kind), currency);
        }
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
    public String doLogin(String loginName, String loginPwd, String kind) {

        User condition = new User();
        condition.setLoginName(loginName);
        condition.setKind(kind);
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
