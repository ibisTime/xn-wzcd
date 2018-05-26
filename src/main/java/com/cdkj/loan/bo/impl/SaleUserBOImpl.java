package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISaleUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PwdUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ISaleUserDAO;
import com.cdkj.loan.domain.SaleUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EUserStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class SaleUserBOImpl extends PaginableBOImpl<SaleUser>
        implements ISaleUserBO {

    @Autowired
    private ISaleUserDAO saleUserDAO;

    @Override
    public void isMobileExist(String mobile, String type) {
        if (StringUtils.isNotBlank(mobile)) { // 判断格式
                                              // PhoneUtil.checkMobile(mobile);
            SaleUser condition = new SaleUser();
            condition.setMobile(mobile);
            condition.setType(type);

            long count = getTotalCount(condition);
            if (count > 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "手机号已经存在");
            }
        }
    }

    @Override
    public int refreshMobile(String userId, String mobile) {
        int count = 0;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(mobile)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setMobile(mobile);
            count = saleUserDAO.updateMobile(data);
        }
        return count;
    }

    @Override
    public int refreshLoginPwd(String userId, String loginPwd) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setLoginPwd(MD5Util.md5(loginPwd));
            data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
            count = saleUserDAO.updateLoginPwd(data);
        }
        return count;
    }

    @Override
    public void refreshPhoto(String userId, String photo) {
        if (StringUtils.isNotBlank(userId)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setPhoto(photo);
            saleUserDAO.updatePhoto(data);
        }
    }

    @Override
    public void refreshStatus(String userId, EUserStatus status, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setStatus(status.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            saleUserDAO.updateStatus(data);
        }
    }

    @Override
    public void checkLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(loginPwd)) {
            SaleUser condition = new SaleUser();
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
    public List<SaleUser> querySaleUserList(SaleUser condition) {
        return saleUserDAO.selectList(condition);
    }

    @Override
    public String getUserIdByMobile(String mobile) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            SaleUser condition = new SaleUser();
            condition.setMobile(mobile);
            List<SaleUser> list = saleUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                SaleUser data = list.get(0);
                userId = data.getUserId();
            }
        }
        return userId;
    }

    @Override
    public SaleUser getSaleUser(String userId) {
        SaleUser SaleUser = null;
        if (StringUtils.isNotBlank(userId)) {
            SaleUser condition = new SaleUser();
            condition.setUserId(userId);
            List<SaleUser> list = saleUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                SaleUser = list.get(0);
            }
        }
        return SaleUser;
    }

    @Override
    public SaleUser getSaleUser(String mobile, String type) {
        SaleUser SaleUser = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(type)) {
            SaleUser condition = new SaleUser();
            condition.setMobile(mobile);
            condition.setType(type);
            List<SaleUser> list = saleUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                SaleUser = list.get(0);
            }
        }
        return SaleUser;
    }

    @Override
    public String getUserId(String mobile, String type) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(type)) {
            SaleUser condition = new SaleUser();
            condition.setMobile(mobile);
            condition.setType(type);
            List<SaleUser> list = saleUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                SaleUser data = list.get(0);
                userId = data.getUserId();
            } else
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "手机号[" + mobile + "]用户不存在");
        }
        return userId;
    }

    @Override
    public String saveSaleUser(String mobile) {
        String userId = null;
        if (StringUtils.isNotBlank(mobile)) {
            userId = OrderNoGenerater.generate("SU");
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setMobile(mobile);
            saleUserDAO.insert(data);
        }
        return userId;
    }

    @Override
    public String doRegister(String mobile, String loginPwd, String type) {

        String userId = OrderNoGenerater.generate("SU");
        SaleUser SaleUser = new SaleUser();
        SaleUser.setUserId(userId);
        SaleUser.setType(type);
        SaleUser.setLoginName(mobile);
        SaleUser.setMobile(mobile);

        SaleUser.setLoginPwd(MD5Util.md5(loginPwd));
        SaleUser.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        SaleUser.setStatus(EUserStatus.NORMAL.getCode());
        SaleUser.setCreateDatetime(new Date());
        saleUserDAO.insert(SaleUser);
        return userId;
    }

    @Override
    public void refreshRole(String userId, String roleCode, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setRoleCode(roleCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            saleUserDAO.updateRole(data);
        }
    }

    @Override
    public void refreshDepartment(String userId, String departmentCode,
            String updater, String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SaleUser data = new SaleUser();
            data.setUserId(userId);
            data.setDepartmentCode(departmentCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            saleUserDAO.updateDepartment(data);
        }
    }

    @Override
    public void refreshLoginPwdOss(SaleUser data, String loginPwd,
            String udpater, String remark) {
        data.setLoginPwd(MD5Util.md5(loginPwd));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        data.setUpdater(udpater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        saleUserDAO.updateLoginPwd(data);
    }

}
