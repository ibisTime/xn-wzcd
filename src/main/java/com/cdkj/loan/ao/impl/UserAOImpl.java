package com.cdkj.loan.ao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ECaptchaType;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EUser;
import com.cdkj.loan.enums.EUserKind;
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

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

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

        // 获取信用分账户
        Account xyfAccount = accountBO.getAccountByUser(userId,
            ECurrency.XYF.getCode());

        // 获取初始信用分配置
        BigDecimal initialScore = sysConfigBO
            .getBigDecimalValue(SysConstants.REGISTER_ADD);

        // 加上信用分
        creditscoreBO.changeCreditscore(xyfAccount, initialScore, userId,
            "注册获取初始信用分");

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

    @Override
    public String doCaptchaLoginReg(String mobile, String smsCaptcha,
            String loginPwd, String confirmPwd) {
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "630080");
        String userId = userBO.getUserIdByMobile(mobile);
        if (StringUtils.isNotBlank(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "手机号已存在，请重新输入！！！");
        }
        if (!loginPwd.equals(confirmPwd)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "两次密码不一致，请重新输入！！！");
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
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录名不存在");
        }

        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<User> userList2 = userBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList2)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录密码错误");
        }

        User user = userList2.get(0);
        if (!EUserStatus.NORMAL.getCode().equals(user.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该账号" + EUserStatus.getMap().get(user.getStatus()).getValue()
                        + "，请联系工作人员");
        }

        return user.getUserId();
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha) {

        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "用户不存在");
        }

        String oldMobile = user.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "新手机与原手机一致");
        }

        // 验证手机号
        userBO.isMobileExist(newMobile, user.getKind());

        // 短信验证码是否正确（往新手机号发送）
        smsOutBO.checkCaptcha(newMobile, smsCaptcha,
            ECaptchaType.CHANGE_MOBILE.getCode());

        userBO.refreshMobile(userId, newMobile);

        // 发送短信
        smsOutBO.sendSmsOut(oldMobile,
            "尊敬的" + PhoneUtil.hideMobile(oldMobile) + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1)
                    + "提交的更改绑定手机号码服务已通过，现绑定手机号码为" + newMobile
                    + "，请妥善保管您的账户相关信息。");
    }

    @Override
    @Transactional
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String kind) {
        String userId = userBO.getUserId(mobile, kind);
        if (StringUtils.isBlank(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "用户不存在,请先注册");
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805063");
        userBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的登录密码重置成功。请妥善保管您的账户相关信息。");
    }

    @Override
    @Transactional
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd) {
        User user = userBO.getUser(userId);
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        userBO.checkLoginPwd(userId, oldLoginPwd);
        // 重置
        userBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        if (EUserKind.Customer.getCode().equals(user.getKind())
                || EUserKind.Merchant.getCode().equals(user.getKind())) {
            smsOutBO.sendSmsOut(user.getMobile(),
                "尊敬的" + PhoneUtil.hideMobile(user.getMobile())
                        + "用户，您的登录密码修改成功。请妥善保管您的账户相关信息。");
        }
    }

    @Override
    @Transactional
    public void doSetTradePwd(String userId, String tradePwd,
            String smsCaptcha) {
        User user = userBO.getUser(userId);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha, "805066");
        // 修改支付密码
        userBO.refreshTradePwd(userId, tradePwd);
        // 发送短信
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码设置成功。请妥善保管您的账户相关信息。");
    }

    @Override
    public void doResetTradePwd(String userId, String newTradePwd,
            String smsCaptcha) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "用户名不存在");
        }
        // 短信验证码是否正确
        String mobile = user.getMobile();
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805067");
        userBO.refreshTradePwd(userId, newTradePwd);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码重置成功。请妥善保管您的账户相关信息。");
    }

    @Override
    @Transactional
    public void doModifyTradePwd(String userId, String oldTradePwd,
            String newTradePwd) {
        if (oldTradePwd.equals(newTradePwd)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "新资金密码与原有资金密码重复");
        }
        User conditon = new User();
        conditon.setUserId(userId);
        conditon.setTradePwd(MD5Util.md5(oldTradePwd));
        List<User> list = userBO.queryUserList(conditon);
        User user = null;
        if (CollectionUtils.isNotEmpty(list)) {
            user = list.get(0);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "旧资金密码不正确");
        }
        userBO.refreshTradePwd(userId, newTradePwd);
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码修改成功。请妥善保管您的账户相关信息。");
    }

    @Override
    public void modifyPhoto(String userId, String photo) {
        userBO.refreshPhoto(userId, photo);
    }

    @Override
    public void modifyNickname(String userId, String nickname) {
        userBO.refreshNickname(userId, nickname);
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
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                userId + "用户不存在");
        } else {
            // 是否设置过交易密码
            if (StringUtils.isNotBlank(user.getTradePwdStrength())) {
                user.setTradepwdFlag(true);
            } else {
                user.setTradepwdFlag(false);
            }

            // 是否实名认证
            if (StringUtils.isNotBlank(user.getRealName())) {
                user.setIdentifyFlag(true);
            } else {
                user.setIdentifyFlag(false);
            }

            // TODO 是否绑定银行卡

        }
        return user;
    }

    @Override
    public void doCloseOpen(String userId, String updater, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "用户不存在");
        }
        // admin 不注销
        if (EUser.ADMIN.getCode().equals(user.getLoginName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "管理员无法注销");
        }
        String mobile = user.getMobile();
        String smsContent = "";
        EUserStatus userStatus = null;
        if (EUserStatus.NORMAL.getCode().equalsIgnoreCase(user.getStatus())) {
            smsContent = "您的账号已被管理员封禁";
            userStatus = EUserStatus.Ren_Locked;
        } else {
            smsContent = "您的账号已被管理员解封,请遵守平台相关规则";
            userStatus = EUserStatus.NORMAL;
        }
        userBO.refreshStatus(userId, userStatus, updater, remark);
        if (!EUserKind.Plat.getCode().equals(user.getKind())) {
            // 发送短信
            smsOutBO.sendSmsOut(mobile,
                "尊敬的" + PhoneUtil.hideMobile(mobile) + smsContent);
        }
    }

}
