/**
 * @Title UserAOImpl.java 
 * @Package com.ibis.pz.user.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:52:06 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.ICtqBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IFieldTimesBO;
import com.cdkj.coin.bo.IGoogleAuthBO;
import com.cdkj.coin.bo.IIdentifyBO;
import com.cdkj.coin.bo.IJourBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ISYSRoleBO;
import com.cdkj.coin.bo.ISmsOutBO;
import com.cdkj.coin.bo.ITencentBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.IUserRelationBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.common.AESUtil;
import com.cdkj.coin.common.DateUtil;
import com.cdkj.coin.common.MD5Util;
import com.cdkj.coin.common.PhoneUtil;
import com.cdkj.coin.common.RandomUtil;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.SYSRole;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.dto.req.XN805042Req;
import com.cdkj.coin.dto.req.XN805043Req;
import com.cdkj.coin.dto.req.XN805095Req;
import com.cdkj.coin.dto.res.XN625000Res;
import com.cdkj.coin.dto.res.XN798011Res;
import com.cdkj.coin.dto.res.XN798012Res;
import com.cdkj.coin.dto.res.XN798013Res;
import com.cdkj.coin.dto.res.XN798014Res;
import com.cdkj.coin.dto.res.XN805041Res;
import com.cdkj.coin.dto.res.XN805123Res;
import com.cdkj.coin.enums.EAccountType;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.enums.ECaptchaType;
import com.cdkj.coin.enums.EChannelType;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.enums.EIDKind;
import com.cdkj.coin.enums.EJourBizTypeUser;
import com.cdkj.coin.enums.ELoginType;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.enums.EUser;
import com.cdkj.coin.enums.EUserKind;
import com.cdkj.coin.enums.EUserStatus;
import com.cdkj.coin.exception.BizException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:52:06 
 * @history:
 */
@Service
public class UserAOImpl implements IUserAO {

    private static Logger logger = Logger.getLogger(UserAOImpl.class);

    @Autowired
    protected IUserBO userBO;

    @Autowired
    protected ICtqBO ctqBO;

    @Autowired
    protected IEthAddressBO ethAddressBO;

    @Autowired
    protected IAccountBO accountBO;

    @Autowired
    protected IJourBO jourBO;

    @Autowired
    protected IUserRelationBO userRelationBO;

    @Autowired
    protected ISYSRoleBO sysRoleBO;

    @Autowired
    IIdentifyBO dentifyBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    protected IFieldTimesBO fieldTimesBO;

    @Autowired
    protected ISYSConfigBO sysConfigBO;

    @Autowired
    ITencentBO tencentBO;

    @Autowired
    IGoogleAuthBO googleAuthBO;

    /** 
     * @see com.std.user.ao.IUserAO#doCheckMobile(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void doCheckMobile(String mobile, String kind, String companyCode,
            String systemCode) {
        userBO.isMobileExist(mobile, kind, companyCode, systemCode);
    }

    @Override
    @Transactional
    public XN805041Res doRegister(String mobile, String nickname,
            String loginPwd, String userReferee, String userRefereeKind,
            String inviteCode, String smsCaptcha, String kind, String province,
            String city, String area, String address, String companyCode,
            String systemCode) {
        // 验证手机号是否存在
        userBO.isMobileExist(mobile, kind, companyCode, systemCode);
        // 检查昵称是否已经被使用
        userBO.isNicknameExist(nickname, kind, companyCode, systemCode);

        String refereeUserId = null;
        User refereeUser = null;

        if (StringUtils.isNotBlank(inviteCode)) {
            try {
                refereeUserId = AESUtil.jdkAESDecryption(inviteCode);
                refereeUser = userBO.getUser(refereeUserId);
                if (refereeUser == null) {
                    throw new BizException("xn000000", "无效的邀请码");
                }
            } catch (Exception e) {
                throw new BizException("无效的邀请码");
            }

        } else {
            if (StringUtils.isNotBlank(userReferee)
                    && StringUtils.isNotBlank(userRefereeKind)) {
                // 验证推荐人是否存在,并将手机号转化为用户编号
                refereeUser = userBO.getUser(userReferee, userRefereeKind,
                    companyCode, systemCode);
                if (refereeUser == null) {
                    throw new BizException("xn000000", "推荐人手机号不存在");
                }
                refereeUserId = refereeUser.getUserId();
            }
        }
        // 验证短信验证码
        smsOutBO.checkCaptcha(mobile, smsCaptcha, ECaptchaType.C_REG.getCode(),
            companyCode, systemCode);
        // 获取默认分成比例
        Double divRate1 = sysConfigBO
            .getDoubleValue(SysConstants.FEN_CHENG_FEE);
        Double divRate2 = sysConfigBO
            .getDoubleValue(SysConstants.AGENT_FEN_CHENG_FEE);
        Double tradeRate = sysConfigBO
            .getDoubleValue(SysConstants.TRADE_FEE_RATE);
        // 注册用户
        String userId = userBO.doRegister(mobile, nickname, loginPwd,
            refereeUser, kind, province, city, area, address, divRate1,
            divRate2, tradeRate, companyCode, systemCode);
        // 分配账户
        distributeAccount(userId, mobile, kind, companyCode, systemCode);
        // 生成ETH地址
        String ethAddress = ethAddressBO.generateAddress(EEthAddressType.X,
            mobile, userId, null, null);
        // 通知橙提取
        ctqBO.uploadAddress(ethAddress, EEthAddressType.X.getCode());

        // 注册腾讯云
        tencentBO.register(userId, nickname, companyCode, systemCode);

        // 腾讯云设置昵称
        // tencentBO.setNickname(userId, nickname);

        // 注册送积分
        Long amount = addRegAmount(userId, mobile, kind, companyCode,
            systemCode);
        // // 第三方账号注册
        // thirdRegist(userId, isRegHx, companyCode, systemCode);

        return new XN805041Res(userId, refereeUserId, amount);
    }

    @Override
    @Transactional
    public void doRegisterAndIdentify(String mobile, String nickname,
            String loginPwd, String realName, String idNo, String userReferee,
            String userRefereeKind, String inviteCode, String kind,
            String province, String city, String area, String address,
            String companyCode, String systemCode) {
        // 验证手机号是否存在
        userBO.isMobileExist(mobile, kind, companyCode, systemCode);
        // 检查昵称是否已经被使用
        userBO.isNicknameExist(nickname, kind, companyCode, systemCode);

        String refereeUserId = null;
        User refereeUser = null;

        if (StringUtils.isNotBlank(inviteCode)) {
            try {
                refereeUserId = AESUtil.jdkAESDecryption(inviteCode);
                refereeUser = userBO.getUser(refereeUserId);
                if (refereeUser == null) {
                    throw new BizException("xn000000", "无效的邀请码");
                }
            } catch (Exception e) {
                throw new BizException("无效的邀请码");
            }

        } else {
            if (StringUtils.isNotBlank(userReferee)
                    && StringUtils.isNotBlank(userRefereeKind)) {
                // 验证推荐人是否存在,并将手机号转化为用户编号
                refereeUser = userBO.getUser(userReferee, userRefereeKind,
                    companyCode, systemCode);
                if (refereeUser == null) {
                    throw new BizException("xn000000", "推荐人手机号不存在");
                }
                refereeUserId = refereeUser.getUserId();
            }
        }
        // 获取默认分成比例
        Double divRate1 = sysConfigBO
            .getDoubleValue(SysConstants.FEN_CHENG_FEE);
        Double divRate2 = sysConfigBO
            .getDoubleValue(SysConstants.AGENT_FEN_CHENG_FEE);
        Double tradeRate = sysConfigBO
            .getDoubleValue(SysConstants.TRADE_FEE_RATE);
        // 注册用户
        String userId = userBO.doRegister(mobile, nickname, loginPwd,
            refereeUser, kind, province, city, area, address, divRate1,
            divRate2, tradeRate, companyCode, systemCode);
        // 分配账户
        distributeAccount(userId, mobile, kind, companyCode, systemCode);
        // 生成ETH地址
        String ethAddress = ethAddressBO.generateAddress(EEthAddressType.X,
            mobile, userId, null, null);
        // 通知橙提取
        ctqBO.uploadAddress(ethAddress, EEthAddressType.X.getCode());

        // 注册腾讯云
        tencentBO.register(userId, nickname, companyCode, systemCode);

        // 实名
        userBO
            .refreshIdentity(userId, realName, EIDKind.IDCard.getCode(), idNo);

    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind,
            String companyCode, String systemCode) {
        List<String> currencyList = new ArrayList<String>();
        // currencyList.add(ECurrency.BTC.getCode());
        currencyList.add(ECoin.ETH.getCode());
        for (String currency : currencyList) {
            accountBO.distributeAccount(userId, mobile,
                EAccountType.getAccountType(kind), currency, systemCode,
                companyCode);
        }
    }

    // 注册送积分
    private Long addRegAmount(String userId, String mobile, String kind,
            String companyCode, String systemCode) {
        Long amount = 0L;
        // 注册送积分
        // if (EUserKind.Customer.getCode().equals(kind)) {
        // SYSConfig sysConfig = sysConfigBO.getConfig(
        // SysConstants.CUSER_LOGIN_ADDJF, companyCode, systemCode);
        // if (null != sysConfig) {
        // amount = AmountUtil.mul(1000L,
        // Double.valueOf(sysConfig.getCvalue()));
        // accountBO.doTransferAmountRemote(getSysUserId(systemCode),
        // userId, ECurrency.CG_JF, amount, EBizType.AJ_REG, "用户["
        // + mobile + "]注册送积分", "注册送积分");
        // }
        // }
        return amount;
    }

    // 每天登录送积分
    private Long addLoginAmount(User user) {
        Long amount = 0L;
        if (EUserKind.Customer.getCode().equals(user.getKind())) {
            // Boolean result = signLogBO.isSignToday(user.getUserId());
            // if (!result) {
            // signLogBO.saveSignLog(user.getUserId(), "",
            // user.getSystemCode());
            // SYSConfig sysConfig = sysConfigBO.getConfig(
            // SysConstant.CUSER_LOGIN_ADDJF, user.getCompanyCode(),
            // user.getSystemCode());
            // if (null != sysConfig) {
            // amount = AmountUtil.mul(1000L,
            // Double.valueOf(sysConfig.getCvalue()));
            // accountBO.doTransferAmountRemote(
            // getSysUserId(user.getSystemCode()), user.getUserId(),
            // ECurrency.CG_JF, amount, EBizType.AJ_SIGN,
            // "用户[" + user.getMobile() + "]登录送积分", "登录送积分");
            // }
            // }
        }
        return amount;
    }

    // 第三方注册
    private void thirdRegist(String userId, String isRegHx, String companyCode,
            String systemCode) {
        // 即时通信注册
        // if (EBoolean.YES.getCode().equals(isRegHx)) {
        // instantMsgImpl.doRegisterUser(userId, systemCode);
        // }
    }

    @Override
    public void doCheckLoginPwd(String userId, String loginPwd) {
        User condition = new User();
        condition.setUserId(userId);
        List<User> userList1 = userBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList1)) {
            throw new BizException("xn702002", "用户不存在");
        }
        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<User> userList2 = userBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList2)) {
            throw new BizException("xn702002", "登录密码错误");
        }

    }

    @Override
    @Transactional
    public String doAddUser(XN805042Req req) {
        String userId = null;
        userId = doAddUserCOIN(req);
        return userId;
    }

    private String doAddUserCOIN(XN805042Req req) {
        String userId = null;
        if (EUserKind.Plat.getCode().equals(req.getKind())) {
            // 验证登录名
            userBO.isLoginNameExist(req.getLoginName(), req.getKind(),
                req.getCompanyCode(), req.getSystemCode());

            userId = userBO.doAddUser(req);
        } else {
            throw new BizException("xn805042", "用户类型" + req.getKind() + "未能识别");
        }
        return userId;
    }

    @Override
    @Transactional
    public String doApplyRegUser(XN805043Req req) {
        String userId = null;
        return userId;
    }

    @Override
    @Transactional
    public String doLogin(String loginName, String loginPwd, String kind,
            String companyCode, String systemCode) {
        User condition = new User();
        if (EUserKind.Customer.getCode().equals(kind)
                || EUserKind.Merchant.getCode().equals(kind)) {
            condition.setLoginName(loginName);
            condition.setLoginType(ELoginType.MOBILE.getCode());
        } else {
            condition.setLoginName(loginName);
        }
        condition.setKind(kind);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
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
            throw new BizException("xn805050", "该账号"
                    + EUserStatus.getMap().get(user.getStatus()).getValue()
                    + "，请联系工作人员");
        }
        addLoginAmount(user);
        userBO.refreshLastLogin(user.getUserId());
        return user.getUserId();
    }

    @Override
    public String doCaptchaLoginReg(String mobile, String kind,
            String smsCaptcha, String companyCode, String systemCode) {
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805051", companyCode,
            systemCode);
        String userId = userBO.getUserId(mobile, kind, companyCode, systemCode);
        if (StringUtils.isNotBlank(userId)) {
            userId = userBO.saveUser(mobile, kind, companyCode, systemCode);
        }
        return userId;
    }

    @Override
    public void doBindMoblie(String userId, String mobile, String smsCaptcha,
            String isSendSms) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        if (StringUtils.isNotBlank(user.getMobile())) {
            throw new BizException("li01004", "手机号已经绑定，无需再次操作");
        }
        // 验证手机号
        userBO.isMobileExist(mobile, EUserKind.Customer.getCode(),
            user.getCompanyCode(), user.getSystemCode());
        // 短信验证码是否正确（往手机号发送）
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805060",
            user.getCompanyCode(), user.getSystemCode());
        // 插入用户信息
        String loginPwd = RandomUtil.generate6();
        userBO.refreshBindMobile(userId, mobile, mobile, loginPwd, "1");
        // 如果用户还未实名认证过，更新Account表realName;
        if (StringUtils.isNotBlank(user.getIdNo())
                && StringUtils.isNotBlank(user.getIdKind())
                && StringUtils.isNotBlank(user.getRealName())) {
            accountBO.refreshAccountName(user.getUserId(), mobile);
        }
        // 发送短信
        if (EBoolean.YES.getCode().equals(isSendSms)) {
            smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                    + "用户，您的登录密码为" + loginPwd + "，请及时登录网站更改密码。", "805060",
                user.getCompanyCode(), user.getSystemCode());
        }
    }

    @Override
    public void doBindEmail(String userId, String email, String captcha) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        // 验证邮箱验证码
        smsOutBO.checkCaptcha(email, captcha, "805081", user.getCompanyCode(),
            user.getSystemCode());
        userBO.refreshEmail(userId, email);
    }

    @Override
    public void doAddRemark(String userId, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        userBO.refreshRemark(userId, remark);
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        String oldMobile = user.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException("xn000000", "新手机与原手机一致");
        }
        // 验证手机号
        userBO.isMobileExist(newMobile, user.getKind(), user.getCompanyCode(),
            user.getSystemCode());
        // 短信验证码是否正确（往新手机号发送）
        smsOutBO.checkCaptcha(newMobile, smsCaptcha, "805061",
            user.getCompanyCode(), user.getSystemCode());
        userBO.refreshMobile(userId, newMobile);
        // 发送短信
        smsOutBO.sendSmsOut(
            oldMobile,
            "尊敬的"
                    + PhoneUtil.hideMobile(oldMobile)
                    + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1)
                    + "提交的更改绑定手机号码服务已审核通过，现绑定手机号码为" + newMobile
                    + "，请妥善保管您的账户相关信息。", "805061", user.getCompanyCode(), user
                .getSystemCode());
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        String oldMobile = user.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException("xn000000", "新手机与原手机一致");
        }
        userBO.isMobileExist(newMobile, user.getKind(), user.getCompanyCode(),
            user.getSystemCode());
        // 验证支付密码
        if (StringUtils.isNotBlank(tradePwd)) {
            userBO.checkTradePwd(userId, tradePwd);
        }
        // 短信验证码是否正确（往新手机号发送）
        smsOutBO.checkCaptcha(newMobile, smsCaptcha, "805062",
            user.getCompanyCode(), user.getSystemCode());
        userBO.refreshMobile(userId, newMobile);
        // 发送短信
        smsOutBO.sendSmsOut(
            oldMobile,
            "尊敬的"
                    + PhoneUtil.hideMobile(oldMobile)
                    + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1)
                    + "提交的更改绑定手机号码服务已审核通过，现绑定手机号码为" + newMobile
                    + "，请妥善保管您的账户相关信息。", "805062", user.getCompanyCode(), user
                .getSystemCode());
    }

    @Override
    @Transactional
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String kind, String companyCode,
            String systemCode) {
        String userId = userBO.getUserId(mobile, kind, companyCode, systemCode);
        if (StringUtils.isBlank(userId)) {
            throw new BizException("li01004", "用户不存在,请先注册");
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805063", companyCode,
            systemCode);
        userBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的登录密码重置成功。请妥善保管您的账户相关信息。", "805063", companyCode,
            systemCode);
    }

    @Override
    @Transactional
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd, String googleCaptcha) {
        User user = userBO.getUser(userId);
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException("li01006", "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        userBO.checkLoginPwd(userId, oldLoginPwd);
        // 校验谷歌验证码
        if (StringUtils.isNotBlank(user.getGoogleSecret())) {
            if (StringUtils.isBlank(googleCaptcha)) {
                throw new BizException("xn000000", "您已开启谷歌认证，请输入谷歌验证码！");
            } else {
                googleAuthBO.checkCode(user.getGoogleSecret(), googleCaptcha,
                    System.currentTimeMillis());
            }
        }
        // 重置
        userBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        if (EUserKind.Customer.getCode().equals(user.getKind())
                || EUserKind.Merchant.getCode().equals(user.getKind())) {
            smsOutBO.sendSmsOut(user.getMobile(),
                "尊敬的" + PhoneUtil.hideMobile(user.getMobile())
                        + "用户，您的登录密码修改成功。请妥善保管您的账户相关信息。", "805064",
                user.getCompanyCode(), user.getSystemCode());
        }
    }

    @Override
    @Transactional
    public void doResetLoginPwdByOss(String userId, String loginPwd,
            String adminUserId, String adminPwd) {
        // 验证当前登录密码是否正确
        userBO.checkLoginPwd(adminUserId, adminPwd, "管理员密码");
        userBO.refreshLoginPwd(userId, loginPwd);
    }

    @Override
    @Transactional
    public void doSetTradePwd(String userId, String tradePwd,
            String smsCaptcha, String googleCaptcha) {
        User user = this.doGetUser(userId);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha, "805066",
            user.getCompanyCode(), user.getSystemCode());
        // 校验谷歌验证码
        if (StringUtils.isNotBlank(user.getGoogleSecret())) {
            if (StringUtils.isBlank(googleCaptcha)) {
                throw new BizException("xn000000", "您已开启谷歌认证，请输入谷歌验证码！");
            } else {
                googleAuthBO.checkCode(user.getGoogleSecret(), googleCaptcha,
                    System.currentTimeMillis());
            }
        }
        // 修改支付密码
        userBO.refreshTradePwd(userId, tradePwd);
        // 发送短信
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码设置成功。请妥善保管您的账户相关信息。", "805066",
            user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    public void doResetTradePwd(String userId, String newTradePwd,
            String smsCaptcha, String googleCaptcha) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li010004", "用户名不存在");
        }
        // 短信验证码是否正确
        String mobile = user.getMobile();
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805067",
            user.getCompanyCode(), user.getSystemCode());
        // 校验谷歌验证码
        if (StringUtils.isNotBlank(user.getGoogleSecret())) {
            if (StringUtils.isBlank(googleCaptcha)) {
                throw new BizException("xn000000", "您已开启谷歌认证，请输入谷歌验证码！");
            } else {
                googleAuthBO.checkCode(user.getGoogleSecret(), googleCaptcha,
                    System.currentTimeMillis());
            }
        }
        userBO.refreshTradePwd(userId, newTradePwd);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码重置成功。请妥善保管您的账户相关信息。", "805067",
            user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    @Transactional
    public void doResetTradePwd(String userId, String newTradePwd,
            String smsCaptcha, String idKind, String idNo) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户名不存在");
        }
        if (user.getIdKind() == null || user.getIdNo() == null) {
            throw new BizException("li01004", "请先实名认证");
        }
        // 证件是否正确
        if (!(user.getIdKind().equalsIgnoreCase(idKind) && user.getIdNo()
            .equalsIgnoreCase(idNo))) {
            throw new BizException("li01009", "身份证不符合");
        }
        // 短信验证码是否正确
        String mobile = user.getMobile();
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "805068",
            user.getCompanyCode(), user.getSystemCode());
        userBO.refreshTradePwd(userId, newTradePwd);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码重置成功。请妥善保管您的账户相关信息。", "805068",
            user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    @Transactional
    public void doModifyTradePwd(String userId, String oldTradePwd,
            String newTradePwd) {
        if (oldTradePwd.equals(newTradePwd)) {
            throw new BizException("li01008", "新资金密码与原有资金密码重复");
        }
        User conditon = new User();
        conditon.setUserId(userId);
        conditon.setTradePwd(MD5Util.md5(oldTradePwd));
        List<User> list = userBO.queryUserList(conditon);
        User user = null;
        if (CollectionUtils.isNotEmpty(list)) {
            user = list.get(0);
        } else {
            throw new BizException("li01008", "旧资金密码不正确");
        }
        userBO.refreshTradePwd(userId, newTradePwd);
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的资金密码修改成功。请妥善保管您的账户相关信息。", "805069",
            user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    public void modifyPhoto(String userId, String photo) {
        userBO.refreshPhoto(userId, photo);
    }

    // // 修改用户信息
    // public void doModifyUserExt(XN805081ZReq req) {
    // }

    // 完善手机号和身份信息
    public void doModfiyMobileAndIds(String userId, String mobile,
            String realName, String idKind, String idNo) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn0110", "用户不存在");
        }
        if (StringUtils.isBlank(user.getMobile())) {
            User data = new User();
            data.setUserId(userId);
            data.setMobile(mobile);
            data.setRealName(realName);
            data.setIdKind(idKind);
            data.setIdNo(idNo);
            userBO.refreshUserSupple(data);
        }
    }

    // 修改经纬度
    public void doModifyLngLat(String userId, String longitude, String latitude) {
    }

    @Override
    public void doCloseOpen(String userId, String updater, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        // admin 不注销
        if (EUser.ADMIN.getCode().equals(user.getLoginName())) {
            throw new BizException("li01004", "管理员无法注销");
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
            smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                    + smsContent, "805091", user.getCompanyCode(),
                user.getSystemCode());
        }
    }

    @Override
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        SYSRole role = sysRoleBO.getSYSRole(roleCode);
        if (role == null) {
            throw new BizException("li01004", "角色不存在");
        }
        if (!user.getSystemCode().equals(role.getSystemCode())) {
            throw new BizException("li01004", "用户和角色系统不对应");
        }
        userBO.refreshRole(userId, roleCode, updater, remark);
    }

    @Override
    public void doApproveUser(String userId, String approver,
            String approveResult, String divRate, String remark) {
        User user = userBO.getUser(userId);
        Double divRateD = null;
        if (!EUserStatus.TO_APPROVE.getCode().equals(user.getStatus())
                && !EUserStatus.APPROVE_NO.getCode().equals(user.getStatus())) {
            throw new BizException("xn000000", "用户不处于待审核状态");
        }
        String userStatus = EUserStatus.APPROVE_NO.getCode();
        if (EBoolean.YES.getCode().equals(approveResult)) {
            userStatus = EUserStatus.NORMAL.getCode();
            divRateD = StringValidater.toDouble(divRate);
        }
        userBO.approveUser(userId, approver, userStatus, divRateD, remark);
    }

    @Override
    public void doModifyDivRate(String userId, Double divRate1,
            Double divRate2, String updater, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        userBO.refreshDivRate(userId, divRate1, divRate2);
    }

    @Override
    public void doModifyTradeRate(String userId, Double tradeRate,
            String updater, String remark) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        userBO.refreshTradeRate(userId, tradeRate);
    }

    @Override
    public void doIdentify(String userId, String idKind, String idNo,
            String realName) {
        // 更新用户表
        userBO
            .refreshIdentity(userId, realName, EIDKind.IDCard.getCode(), idNo);
        // // 回写Account表realName;
        // accountBO.refreshRealName(user.getUserId(), realName,
        // user.getSystemCode());
    }

    @Override
    public void doTwoIdentify(String userId, String idKind, String idNo,
            String realName) {
        User user = userBO.getUser(userId);
        dentifyBO.doTwoIdentify(user.getSystemCode(), user.getCompanyCode(),
            userId, realName, idKind, idNo);
        // 更新用户表
        userBO
            .refreshIdentity(userId, realName, EIDKind.IDCard.getCode(), idNo);
        // // 回写Account表realName;
        // accountBO.refreshRealName(user.getUserId(), realName,
        // user.getSystemCode());
    }

    @Override
    public void doFourIdentify(String userId, String idKind, String idNo,
            String realName, String cardNo, String bindMobile) {
        // 三方认证
        dentifyBO.doFourIdentify(userId, realName, idKind, idNo, cardNo,
            bindMobile);
        // 更新用户表
        userBO
            .refreshIdentity(userId, realName, EIDKind.IDCard.getCode(), idNo);
        // // 回写Account表realName;
        // accountBO.refreshRealName(user.getUserId(), realName,
        // user.getSystemCode());
    }

    @Override
    public Object doAlipayZhimaIdentify(String userId, String idKind,
            String idNo, String realName) {
        User user = userBO.getUser(userId);
        // 判断库中是否有该记录
        userBO.checkIdentify(user.getKind(), idKind, idNo, realName);
        // 芝麻认证 有两种结果：如果本地有记录，返回成功；如果本地无记录，返货芝麻认证所需信息
        XN798011Res res = dentifyBO.doAlipayZhimaVerify(user.getSystemCode(),
            user.getSystemCode(), userId, idKind, idNo, realName);
        // 如果直接返回成功
        if (res.isSuccess()) {
            // 更新用户表
            userBO.refreshIdentity(userId, realName, EIDKind.IDCard.getCode(),
                idNo);
        }
        return res;
    }

    @Override
    public Object doAlipayZhimaQuery(String userId, String bizNo) {
        User user = userBO.getUser(userId);
        XN798012Res res = dentifyBO.doAlipayZhimaQuery(user.getSystemCode(),
            user.getSystemCode(), bizNo);
        if (res.isSuccess()) {
            // 更新用户表
            userBO.refreshIdentity(userId, res.getRealName(), res.getIdKind(),
                res.getIdNo());
        }
        return res;
    }

    @Override
    public Object doZhimaIdentify(String userId, String idKind, String idNo,
            String realName, String returnUrl, String localCheck) {
        User user = userBO.getUser(userId);
        // 判断库中是否有该记录
        userBO.checkIdentify(user.getKind(), idKind, idNo, realName);
        // 芝麻认证 有两种结果：如果本地有记录，返回成功；如果本地无记录，返货芝麻认证所需信息
        XN798013Res res = dentifyBO.doZhimaVerify(user.getSystemCode(),
            user.getSystemCode(), userId, idKind, idNo, realName, returnUrl,
            localCheck, "倍可盈-芝麻认证");
        // 如果直接返回成功
        if (res.isSuccess()) {
            // 更新用户表
            userBO.refreshIdentity(userId, realName, EIDKind.IDCard.getCode(),
                idNo);
        }
        return res;
    }

    @Override
    public Object doZhimaQuery(String userId, String bizNo) {
        User user = userBO.getUser(userId);
        XN798014Res res = dentifyBO.doZhimaQuery(user.getSystemCode(),
            user.getSystemCode(), bizNo);
        if (res.isSuccess()) {
            // 更新用户表
            userBO.refreshIdentity(userId, res.getRealName(), res.getIdKind(),
                res.getIdNo());
        }
        return res;
    }

    @Override
    @Transactional
    public void doModifyUser(XN805095Req req) {
        User dbUser = userBO.getUser(req.getUserId());
        if (dbUser == null) {
            throw new BizException("xn000000", "该用户编号不存在！");
        }
        User condition = new User();
        condition.setKind(dbUser.getKind());
        condition.setProvince(req.getProvince());
        condition.setCity(req.getCity());
        condition.setArea(req.getArea());
        List<User> list = userBO.queryUserList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            User user = list.get(0);
            if (!user.getUserId().equals(req.getUserId())) {
                throw new BizException("xn000000", "该辖区已存在合伙人！");
            }
        }

        User data = new User();
        data.setUserId(req.getUserId());
        data.setMobile(req.getMobile());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());

        data.setRealName(req.getRealName());
        data.setDivRate1(StringValidater.toDouble(req.getDivRate()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setStatus(dbUser.getStatus());

        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());

        userBO.refreshUser(data);
    }

    @Override
    public Paginable<User> queryUserPage(int start, int limit, User condition) {
        Paginable<User> page = userBO.getPaginable(start, limit, condition);
        List<User> list = page.getList();
        for (User user : list) {
            // 推荐人转义
            User userReferee = userBO.getUser(user.getUserReferee());
            if (userReferee != null) {
                user.setRefereeUser(userReferee);
            }
        }
        return page;
    }

    @Override
    public List<User> queryUserList(User condition) {
        return userBO.queryUserList(condition);
    }

    @Override
    public List<User> getUserRefereeList(String userId) {
        List<User> list = new ArrayList<User>();
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", userId + "用户不存在");
        }
        String refeere = user.getUserReferee();
        // 获取上级
        User userRefeereTop1 = getTopUserRefeere(refeere, -1);
        if (userRefeereTop1 != null) {
            list.add(userRefeereTop1);
        }

        // 获取下级，下下级，下下下级
        List<User> refeeresNext1 = getNextUserRefeere(userId, 1);
        if (CollectionUtils.isNotEmpty(refeeresNext1)) {
            list.addAll(refeeresNext1);
            for (User userNext2 : refeeresNext1) {
                List<User> refeeresNext2 = getNextUserRefeere(
                    userNext2.getUserId(), 2);
                if (CollectionUtils.isNotEmpty(refeeresNext2)) {
                    list.addAll(refeeresNext2);
                }
                for (User userNext3 : refeeresNext2) {
                    List<User> refeeresNext3 = getNextUserRefeere(
                        userNext3.getUserId(), 3);
                    if (CollectionUtils.isNotEmpty(refeeresNext3)) {
                        list.addAll(refeeresNext3);
                    }
                }
            }
        }
        return list;
    }

    private User getTopUserRefeere(String userId, int refeereLevel) {
        User userRefeere = userBO.getUser(userId);
        if (userRefeere != null) {
            userRefeere.setRefeereLevel(refeereLevel);
        }
        return userRefeere;
    }

    private List<User> getNextUserRefeere(String userId, int refeereLevel) {
        List<User> userList = userBO.getUsersByUserReferee(userId);
        if (CollectionUtils.isNotEmpty(userList)) {
            for (User user : userList) {
                user.setRefeereLevel(refeereLevel);
            }
        }
        return userList;
    }

    @Override
    public User doGetUser(String userId) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", userId + "用户不存在");
        } else {
            // 拉取推荐人信息
            User refereeUser = userBO.getUser(user.getUserReferee());
            user.setRefereeUser(refereeUser);
            // 是否设置过交易密码
            if (StringUtils.isNotBlank(user.getTradePwdStrength())) {
                user.setTradepwdFlag(true);
            } else {
                user.setTradepwdFlag(false);
            }
            // 是否开始谷歌认证
            if (StringUtils.isNotBlank(user.getGoogleSecret())) {
                user.setGoogleAuthFlag(true);
            } else {
                user.setGoogleAuthFlag(false);
            }

        }
        return user;
    }

    /** 
     * @see com.std.user.ao.IUserAO#doGetUserIdByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String doGetUserIdByCondition(String mobile, String kind,
            String companyCode, String systemCode) {
        String userId = null;
        User condition = new User();
        condition.setMobile(mobile);
        condition.setKind(kind);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        List<User> userList = userBO.queryUserList(condition);
        if (CollectionUtils.isNotEmpty(userList)) {
            User user = userList.get(0);
            if (EUserStatus.NORMAL.getCode().equals(user.getStatus())) {
                userId = user.getUserId();
            }
        }
        return userId;
    }

    @Override
    public void doCheckTradePwd(String userId, String tradePwd) {
        userBO.checkTradePwd(userId, tradePwd);
    }

    /**
     * @param response  可能是Json & Jsonp字符串 & urlParas
     *          eg：urlParas：access_token=xxx&expires_in=7776000&refresh_token=xxx
     * @return
     */
    public Map<String, String> getMapFromResponse(String response) {
        if (StringUtils.isBlank(response)) {
            return new HashMap<>();
        }

        Map<String, String> result = new HashMap<>();
        int begin = response.indexOf("{");
        int end = response.lastIndexOf("}") + 1;

        if (begin >= 0 && end > 0) {
            result = new Gson().fromJson(response.substring(begin, end),
                new TypeToken<Map<String, Object>>() {
                }.getType());
        } else {
            String[] paras = response.split("&");
            for (String para : paras) {
                result.put(para.split("=")[0], para.split("=")[1]);
            }
        }

        return result;
    }

    /** 
     * @see com.std.user.ao.IUserAO#doUpLevel(java.lang.String, java.lang.String)
     */
    @Override
    public void doUpLevel(String userId, String level) {
        User data = new User();
        data.setUserId(userId);
        data.setLevel(level);
        userBO.refreshLevel(data);
    }

    @Override
    public XN625000Res getTencentSign(String userId) {
        return tencentBO.getSign(userId, ESystemCode.COIN.getCode(),
            ESystemCode.COIN.getCode());
    }

    @Override
    public XN805123Res getInviteInfo(String userId) {
        XN805123Res res = new XN805123Res();

        User condition = new User();
        condition.setUserReferee(userId);
        res.setInviteCount(userBO.getTotalCount(condition));

        Account account = accountBO.getAccountByUser(userId,
            ECoin.ETH.getCode());
        BigDecimal totalAmount = jourBO.getTotalAmount(
            EJourBizTypeUser.AJ_INVITE.getCode(), EChannelType.NBZ.getCode(),
            account.getAccountNumber(), null, null);
        res.setInviteProfit(totalAmount.toString());

        return res;
    }

    @Override
    public void lastLogin(String userId) {
        userBO.refreshLastLogin(userId);
    }

    @Override
    public void openGoogleAuth(String userId, String secret, String smsCaptcha,
            String googleCaptcha) {
        User user = this.doGetUser(userId);
        // 校验谷歌验证码
        googleAuthBO.checkCode(secret, googleCaptcha,
            System.currentTimeMillis());
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha, "805071",
            user.getCompanyCode(), user.getSystemCode());
        // 修改谷歌验证秘钥
        userBO.refreshGoogleSecret(userId, secret);
    }

    @Override
    public void closeGoogleAuth(String userId, String smsCaptcha,
            String googleCaptcha) {
        User user = this.doGetUser(userId);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha, "805072",
            user.getCompanyCode(), user.getSystemCode());
        // 校验谷歌验证码
        googleAuthBO.checkCode(user.getGoogleSecret(), googleCaptcha,
            System.currentTimeMillis());
        // 重置谷歌验证秘钥
        userBO.refreshGoogleSecret(userId, null);
    }

    @Override
    public void addUserReferee(String userId, String userReferee,
            String userRefereeKind) {
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "编号为" + userId + "的用户不存在");
        }
        if (StringUtils.isNotBlank(user.getUserReferee())) {
            throw new BizException("xn000000", "该用户已经有推荐人");
        }
        // 验证推荐人是否存在,并将手机号转化为用户编号
        User refereeUser = userBO.getUser(userReferee, userRefereeKind,
            ESystemCode.COIN.getCode(), ESystemCode.COIN.getCode());
        if (refereeUser == null) {
            throw new BizException("xn000000", "推荐人手机号不存在");
        }
        if (userId.equals(refereeUser.getUserId())) {
            throw new BizException("xn000000", "推荐人不能是用户本人");
        }
        userBO.refreshUserReferee(userId, refereeUser.getUserId(),
            refereeUser.getLevel());
    }

}
