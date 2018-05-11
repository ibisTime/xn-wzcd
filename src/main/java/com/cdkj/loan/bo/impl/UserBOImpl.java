package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PwdUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IUserDAO;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EUserStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class UserBOImpl extends PaginableBOImpl<User> implements IUserBO {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public void isMobileExist(String mobile, String kind) {
        if (StringUtils.isNotBlank(mobile)) { // 判断格式
                                              // PhoneUtil.checkMobile(mobile);
            User condition = new User();
            condition.setMobile(mobile);
            condition.setKind(kind);

            long count = getTotalCount(condition);
            if (count > 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "手机号已经存在");
            }
        }
    }

    @Override
    public void isNicknameExist(String nickname, String kind) {
        if (StringUtils.isNotBlank(nickname)) { // 判断格式 User condition = new
            User condition = new User(); // User();
            condition.setNickname(nickname);
            condition.setKind(kind);
            long count = getTotalCount(condition);
            if (count > 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "昵称已经被使用");
            }
        }
    }

    /*
     * @Override public void isLoginNameExist(String loginName) { if
     * (StringUtils.isNotBlank(loginName)) { // 判断格式 User condition = new
     * User(); condition.setLoginName(loginName); long count =
     * getTotalCount(condition); if (count > 0) { throw new
     * BizException("li01003", "登录名已经存在"); } } }
     */

    // @Override
    // public void checkLoginPwd(String userId, String loginPwd) {
    // if (StringUtils.isNotBlank(userId)
    // && StringUtils.isNotBlank(loginPwd)) {
    // User condition = new User();
    // condition.setUserId(userId);
    // condition.setLoginPwd(MD5Util.md5(loginPwd));
    // long count = this.getTotalCount(condition);
    // if (count != 1) {
    // throw new BizException("jd00001", "原登录密码错误");
    // }
    // } else {
    // throw new BizException("jd00001", "原登录密码错误");
    // }
    // }

    /*
     * @Override public void checkUserReferee(String userReferee, String
     * systemCode) { if (StringUtils.isNotBlank(userReferee)) { // 判断格式 User
     * condition = new User(); condition.setUserId(userReferee); long count =
     * getTotalCount(condition); if (count <= 0) { throw new
     * BizException("li01003", "推荐人不存在"); } } }
     */

    @Override
    public List<User> queryUserList(User condition) {
        return userDAO.selectList(condition);
    }

    @Override
    public String getUserIdByMobile(String mobile) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            User condition = new User();
            condition.setMobile(mobile);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                User data = list.get(0);
                userId = data.getUserId();
            }
        }
        return userId;
    }

    @Override
    public User getUser(String userId) {
        User user = null;
        if (StringUtils.isNotBlank(userId)) {
            User condition = new User();
            condition.setUserId(userId);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                user = list.get(0);
            }
        }
        return user;
    }

    @Override
    public User getUserById(String userId) {
        User user = null;
        if (StringUtils.isNotBlank(userId)) {
            User condition = new User();
            condition.setUserId(userId);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                user = list.get(0);
            }
        }
        return user;
    }

    @Override
    public String saveUser(String mobile) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            userId = OrderNoGenerater.generate("U");
            User data = new User();
            data.setUserId(userId);
            data.setMobile(mobile);
            userDAO.insert(data);
        }
        return userId;
    }

    @Override
    public String saveCNavigate(User data) {
        String userId = null;
        if (data != null) {
            if (data.getUserId() == null) {
                userId = OrderNoGenerater
                    .generate(EGeneratePrefix.DH.getCode());
                data.setUserId(userId);
            }
            userDAO.insert(data);
        }
        return userId;
    }

    @Override
    public String doRegister(String mobile, String nickname, String loginPwd,
            String kind) {

        String userId = OrderNoGenerater.generate("U");
        User user = new User();
        user.setUserId(userId);
        user.setKind(kind);
        user.setLoginName(mobile);
        user.setMobile(mobile);

        user.setLoginPwd(MD5Util.md5(loginPwd));
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));

        userDAO.insert(user);
        return userId;
    }

    @Override
    public String doRegisterAndIdentify(String mobile, String idKind,
            String realName, String idNo) {
        String userId = OrderNoGenerater.generate("U");
        String loginPwd = "888888";
        User user = new User();
        user.setUserId(userId);
        user.setMobile(mobile);
        user.setLoginName(mobile);
        user.setLoginPwd(loginPwd);
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        user.setIdKind(idKind);
        user.setIdNo(StringValidater.toLong(idNo));
        user.setRealName(realName);
        user.setJfAmount(0L);
        user.setAmount(0L);
        user.setStatus(EUserStatus.NORMAL.getCode());
        user.setCreateDatetime(new Date());
        userDAO.insert(user);
        return userId;
    }

}
