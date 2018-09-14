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
import com.cdkj.loan.dao.IUserDAO;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.enums.EUserSign;
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

    @Override
    public int refreshMobile(String userId, String mobile) {
        int count = 0;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(mobile)) {
            User data = new User();
            data.setUserId(userId);
            data.setMobile(mobile);
            count = userDAO.updateMobile(data);
        }
        return count;
    }

    @Override
    public int refreshLoginPwd(String userId, String loginPwd) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setLoginPwd(MD5Util.md5(loginPwd));
            data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
            count = userDAO.updateLoginPwd(data);
        }
        return count;
    }

    @Override
    public int refreshTradePwd(String userId, String tradePwd) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setTradePwd(MD5Util.md5(tradePwd));
            data.setTradePwdStrength(PwdUtil.calculateSecurityLevel(tradePwd));
            count = userDAO.updateTradePwd(data);
        }
        return count;
    }

    @Override
    public void refreshNickname(String userId, String nickname) {
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setNickname(nickname);
            userDAO.updateNickname(data);
        }
    }

    @Override
    public void refreshPhoto(String userId, String photo) {
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setPhoto(photo);
            userDAO.updatePhoto(data);
        }
    }

    @Override
    public void refreshStatus(String userId, EUserStatus status, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            User data = new User();
            data.setUserId(userId);
            data.setStatus(status.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            userDAO.updateStatus(data);
        }
    }

    @Override
    public void refreshGreenSign(User data, String updater) {
        if (data != null) {
            // 如果原本是红名单和黄名单，状态不变；如果原本是绿名单，状态和时间不用变
            if (EUserSign.WHITE.getCode().equals(data.getSign())) {
                data.setSign(EUserSign.GREEN.getCode());
                data.setSignDatetime(new Date());
            }
            data.setTotalGreenCount(data.getTotalGreenCount() + 1);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            userDAO.updateGreenSign(data);
        }
    }

    @Override
    public void refreshYellowSign(User data, String updater) {
        if (data != null) {
            // 如果原本是红名单，状态不变；如果原本是黄名单，状态和时间不用变
            if (!EUserSign.RED.getCode().equals(data.getSign())
                    && !EUserSign.YELLOW.getCode().equals(data.getSign())) {
                data.setSign(EUserSign.YELLOW.getCode());
                data.setSignDatetime(new Date());
            }
            data.setTotalYellowCount(data.getTotalYellowCount() + 1);
            // 三次黄名单进入红名单
            if (data.getTotalYellowCount() >= 3) {
                data.setSign(EUserSign.RED.getCode());
            }
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            userDAO.updateYellowSign(data);
        }
    }

    @Override
    public void refreshRedSign(User data, String updater) {
        if (data != null) {
            // 如果原本是红名单，状态和时间不用变
            if (!EUserSign.RED.getCode().equals(data.getSign())) {
                data.setSign(EUserSign.RED.getCode());
                data.setSignDatetime(new Date());
            }
            data.setTotalRedCount(data.getTotalRedCount() + 1);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            userDAO.updateRedSign(data);
        }
    }

    @Override
    public void refreshBlackSign(User data, String updater) {
        if (data != null) {
            data.setSign(EUserSign.BLACK.getCode());
            data.setSignDatetime(new Date());
            data.setTotalBlackCount(data.getTotalBlackCount() + 1);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            userDAO.updateBlackSign(data);
        }
    }

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(tradePwd)) {
            User user = this.getUser(userId);
            if (StringUtils.isBlank(user.getTradePwdStrength())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "请您先设置资金密码！");
            }
            User condition = new User();
            condition.setUserId(userId);
            condition.setTradePwd(MD5Util.md5(tradePwd));
            if (this.getTotalCount(condition) != 1) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资金密码错误");
            }
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "资金密码错误");
        }
    }

    @Override
    public void checkLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(loginPwd)) {
            User condition = new User();
            condition.setUserId(userId);
            condition.setLoginPwd(MD5Util.md5(loginPwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "原登录密码错误");
            }
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "原登录密码错误");
        }
    }

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
    public String getUserIdById(String idKind, String idNo) {
        String userId = null;
        if (StringUtils.isNotBlank(idNo)) {
            User condition = new User();
            condition.setIdKind(idKind);
            condition.setIdNo(idNo);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                User data = list.get(0);
                userId = data.getUserId();
            }
        }
        return userId;
    }

    @Override
    public String getUserIdByCondition(String mobile, String realName,
            String idKind, String idNo) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            User condition = new User();
            condition.setMobile(mobile);
            condition.setRealName(realName);
            condition.setIdKind(idKind);
            condition.setIdNo(idNo);
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
    public User getUser(String mobile, String kind) {
        User user = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(kind)) {
            User condition = new User();
            condition.setMobile(mobile);
            condition.setKind(kind);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                user = list.get(0);
            }
        }
        return user;
    }

    @Override
    public String getUserId(String mobile, String kind) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(kind)) {
            User condition = new User();
            condition.setMobile(mobile);
            condition.setKind(kind);
            List<User> list = userDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                User data = list.get(0);
                userId = data.getUserId();
            } else
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "手机号[" + mobile + "]用户不存在");
        }
        return userId;
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
    public String doRegister(String mobile, String nickname, String loginPwd,
            String kind) {

        String userId = OrderNoGenerater.generate("U");
        User user = new User();
        user.setUserId(userId);
        user.setKind(kind);
        user.setLoginName(mobile);
        user.setMobile(mobile);
        user.setNickname(nickname);

        user.setLoginPwd(MD5Util.md5(loginPwd));
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        user.setStatus(EUserStatus.NORMAL.getCode());
        user.setCreateDatetime(new Date());
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
        user.setKind(EUserKind.Customer.getCode());
        user.setMobile(mobile);
        user.setLoginName(mobile);
        user.setLoginPwd(MD5Util.md5(loginPwd));
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        user.setIdKind(idKind);
        user.setIdNo(idNo);
        user.setRealName(realName);
        user.setStatus(EUserStatus.NORMAL.getCode());
        user.setSign(EUserSign.WHITE.getCode());
        user.setSignDatetime(new Date());
        user.setTotalGreenCount(0);
        user.setTotalYellowCount(0);
        user.setTotalRedCount(0);
        user.setCreateDatetime(new Date());
        userDAO.insert(user);
        return userId;
    }

}
