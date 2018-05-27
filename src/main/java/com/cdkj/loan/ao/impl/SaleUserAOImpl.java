package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.ICreditscoreBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISaleUserBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SaleUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EUser;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.enums.EUserStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class SaleUserAOImpl implements ISaleUserAO {

    @Autowired
    private ISaleUserBO saleUserBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    ISYSRoleBO sysRoleBO;

    @Autowired
    IDepartmentBO departmentBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    ICreditscoreBO creditscoreBO;

    @Override
    @Transactional
    public String doRegister(String mobile, String loginPwd, String smsCaptcha,
            String type) {

        // 验证手机号是否存在
        saleUserBO.isMobileExist(mobile, type);

        // 验证短信验证码
        // smsOutBO.checkCaptcha(mobile, smsCaptcha,
        // ECaptchaType.C_REG.getCode());

        // 注册业务员
        String userId = saleUserBO.doRegister(mobile, loginPwd, type);

        return userId;
    }

    @Override
    public String doCaptchaLoginReg(String mobile, String smsCaptcha,
            String loginPwd, String confirmPwd) {
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "630080");
        String userId = saleUserBO.getUserIdByMobile(mobile);
        if (StringUtils.isNotBlank(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "手机号已存在，请重新输入！！！");
        }
        if (!loginPwd.equals(confirmPwd)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "两次密码不一致，请重新输入！！！");
        }
        userId = saleUserBO.saveSaleUser(mobile);
        return userId;
    }

    // 业务员登录
    @Override
    @Transactional
    public String doLogin(String loginName, String loginPwd, String type) {

        SaleUser condition = new SaleUser();
        condition.setLoginName(loginName);
        condition.setType(type);
        List<SaleUser> SaleUserList1 = saleUserBO.querySaleUserList(condition);

        if (CollectionUtils.isEmpty(SaleUserList1)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录名不存在");
        }

        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<SaleUser> SaleUserList2 = saleUserBO.querySaleUserList(condition);
        if (CollectionUtils.isEmpty(SaleUserList2)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录密码错误");
        }

        SaleUser SaleUser = SaleUserList2.get(0);
        if (!EUserStatus.NORMAL.getCode().equals(SaleUser.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该账号"
                    + EUserStatus.getMap().get(SaleUser.getStatus()).getValue()
                    + "，请联系工作人员");
        }

        return SaleUser.getUserId();
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha) {

        SaleUser SaleUser = saleUserBO.getSaleUser(userId);
        if (SaleUser == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "业务员不存在");
        }

        String oldMobile = SaleUser.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "新手机与原手机一致");
        }

        // 验证手机号
        saleUserBO.isMobileExist(newMobile, SaleUser.getType());

        // 短信验证码是否正确（往新手机号发送）
        // smsOutBO.checkCaptcha(newMobile, smsCaptcha,
        // ECaptchaType.CHANGE_MOBILE.getCode());

        saleUserBO.refreshMobile(userId, newMobile);

        // 发送短信
        // smsOutBO.sendSmsOut(oldMobile,
        // "尊敬的" + PhoneUtil.hideMobile(oldMobile) + "业务员，您于"
        // + DateUtil.dateToStr(new Date(),
        // DateUtil.DATA_TIME_PATTERN_1)
        // + "提交的更改绑定手机号码服务已通过，现绑定手机号码为" + newMobile
        // + "，请妥善保管您的账户相关信息。");
    }

    @Override
    @Transactional
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd, String type) {
        String userId = saleUserBO.getUserId(mobile, type);
        if (StringUtils.isBlank(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "业务员不存在,请先注册");
        }
        // 短信验证码是否正确
        // smsOutBO.checkCaptcha(mobile, smsCaptcha, "805063");
        saleUserBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        // smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
        // + "业务员，您的登录密码重置成功。请妥善保管您的账户相关信息。");
    }

    @Override
    @Transactional
    public void doResetLoginPwdByOss(String userId, String loginPwd,
            String udpater, String remark) {

        SaleUser SaleUser = saleUserBO.getSaleUser(userId);
        saleUserBO.refreshLoginPwdOss(SaleUser, loginPwd, udpater, remark);
    }

    @Override
    @Transactional
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd) {
        SaleUser SaleUser = saleUserBO.getSaleUser(userId);
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        saleUserBO.checkLoginPwd(userId, oldLoginPwd);
        // 重置
        saleUserBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        if (EUserKind.Customer.getCode().equals(SaleUser.getType())
                || EUserKind.Merchant.getCode().equals(SaleUser.getType())) {
            smsOutBO.sendSmsOut(SaleUser.getMobile(),
                "尊敬的" + PhoneUtil.hideMobile(SaleUser.getMobile())
                        + "业务员，您的登录密码修改成功。请妥善保管您的账户相关信息。");
        }
    }

    @Override
    public void modifyPhoto(String userId, String photo) {
        saleUserBO.refreshPhoto(userId, photo);
    }

    @Override
    public Paginable<SaleUser> querySaleUserPage(int start, int limit,
            SaleUser condition) {
        return saleUserBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SaleUser> querySaleUserList(SaleUser condition) {
        return saleUserBO.querySaleUserList(condition);
    }

    @Override
    public SaleUser getSaleUser(String userId) {
        SaleUser SaleUser = saleUserBO.getSaleUser(userId);
        if (SaleUser == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                userId + "业务员不存在");
        } else {

            // TODO 是否绑定银行卡

        }
        return SaleUser;
    }

    @Override
    public void doCloseOpen(String userId, String updater, String remark) {
        SaleUser SaleUser = saleUserBO.getSaleUser(userId);
        if (SaleUser == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "业务员不存在");
        }
        // admin 不注销
        if (EUser.ADMIN.getCode().equals(SaleUser.getLoginName())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "管理员无法注销");
        }
        String mobile = SaleUser.getMobile();
        String smsContent = "";
        EUserStatus SaleUserStatus = null;
        if (EUserStatus.NORMAL.getCode()
            .equalsIgnoreCase(SaleUser.getStatus())) {
            smsContent = "您的账号已被管理员封禁";
            SaleUserStatus = EUserStatus.Ren_Locked;
        } else {
            smsContent = "您的账号已被管理员解封,请遵守平台相关规则";
            SaleUserStatus = EUserStatus.NORMAL;
        }
        saleUserBO.refreshStatus(userId, SaleUserStatus, updater, remark);
        if (!EUserKind.Plat.getCode().equals(SaleUser.getType())) {
            // 发送短信
            smsOutBO.sendSmsOut(mobile,
                "尊敬的" + PhoneUtil.hideMobile(mobile) + smsContent);
        }
    }

    @Override
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark) {
        SaleUser user = saleUserBO.getSaleUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "业务员不存在");
        }
        SYSRole role = sysRoleBO.getSYSRole(roleCode);
        if (role == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "角色不存在");
        }
        saleUserBO.refreshRole(userId, roleCode, updater, remark);
    }

    @Override
    public void doSetDepartment(String userId, String departmentCode,
            String updater, String remark) {
        SaleUser user = saleUserBO.getSaleUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "业务员不存在");
        }
        Department department = departmentBO.getDepartment(departmentCode);
        if (department == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "部门不存在");
        }
        saleUserBO.refreshDepartment(userId, departmentCode, updater, remark);
    }

}
