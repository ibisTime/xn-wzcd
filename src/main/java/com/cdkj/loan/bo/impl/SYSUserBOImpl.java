package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PhoneUtil;
import com.cdkj.loan.common.PwdUtil;
import com.cdkj.loan.dao.ISYSUserDAO;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ESYSUserStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class SYSUserBOImpl extends PaginableBOImpl<SYSUser>
        implements ISYSUserBO {

    @Autowired
    private ISYSUserDAO sysUserDAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public void resetAdminLoginPwd(SYSUser user, String loginPwd) {
        user.setLoginPwd(MD5Util.md5(loginPwd));
        user.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        sysUserDAO.updateLoginPwd(user);
    }

    @Override
    public void refreshMobile(String userId, String mobile) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(mobile)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setMobile(mobile);
            sysUserDAO.updateMobile(data);
        }
    }

    @Override
    public void refreshRole(String userId, String roleCode, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setRoleCode(roleCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            sysUserDAO.updateRole(data);
        }
    }

    @Override
    public void refreshPost(String userId, String postCode,
            String departmentCode, String companyCode, String updater,
            String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setPostCode(postCode);
            data.setDepartmentCode(departmentCode);
            data.setCompanyCode(companyCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            sysUserDAO.updatePost(data);
        }
    }

    @Override
    public void refreshStatus(String userId, ESYSUserStatus status,
            String updater, String remark) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setStatus(status.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            sysUserDAO.updateStatus(data);
        }
    }

    @Override
    public void isMobileExist(String mobile) {
        if (StringUtils.isNotBlank(mobile)) {
            // 判断格式
            PhoneUtil.checkMobile(mobile);
            SYSUser condition = new SYSUser();
            condition.setMobile(mobile);
            long count = getTotalCount(condition);
            if (count > 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "手机号已经存在");
            }
        }
    }

    @Override
    public void refreshLoginPwd(SYSUser data, String loginPwd, String udpater,
            String remark) {
        data.setLoginPwd(MD5Util.md5(loginPwd));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        data.setUpdater(udpater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        sysUserDAO.updateLoginPwd(data);
    }

    @Override
    public void refreshLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = getUser(userId);
            data.setLoginPwd(MD5Util.md5(loginPwd));
            data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
            sysUserDAO.updateLoginPwd(data);
        }
    }

    @Override
    public void refreshPhoto(String userId, String photo) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setPhoto(photo);
            sysUserDAO.updatePhoto(data);
        }
    }

    @Override
    public boolean isUserExist(String code) {
        SYSUser condition = new SYSUser();
        if (sysUserDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveUser(SYSUser data) {
        sysUserDAO.insert(data);
    }

    @Override
    public List<SYSUser> queryUserList(SYSUser condition) {
        return sysUserDAO.selectList(condition);
    }

    @Override
    public SYSUser getUser(String userId) {
        SYSUser data = null;
        if (StringUtils.isNotBlank(userId)) {
            SYSUser condition = new SYSUser();
            condition.setUserId(userId);
            data = sysUserDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "用户不存在");
            }
        }
        return data;
    }

    @Override
    public SYSUser getUserByLoginName(String loginName) {
        SYSUser sysUser = null;
        if (StringUtils.isNotBlank(loginName)) {
            SYSUser condition = new SYSUser();
            condition.setLoginName(loginName);
            List<SYSUser> userList = sysUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(userList)) {
                sysUser = userList.get(0);
            }
        }
        return sysUser;
    }

    @Override
    public SYSUser getUserByMobile(String mobile) {
        SYSUser sysUser = null;
        if (StringUtils.isNotBlank(mobile)) {
            SYSUser condition = new SYSUser();
            condition.setMobile(mobile);
            List<SYSUser> userList = sysUserDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(userList)) {
                sysUser = userList.get(0);
            }
        }
        return sysUser;
    }

    @Override
    public SYSUser getMoreUser(String userId) {
        SYSUser data = null;
        if (StringUtils.isNotBlank(userId)) {
            SYSUser condition = new SYSUser();
            condition.setUserId(userId);
            data = sysUserDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "用户不存在");
            }
            // 获取岗位
            Department post = departmentBO.getDepartment(data.getPostCode());
            data.setPostName(post.getName());

            // 获取部门
            Department department = departmentBO
                .getDepartment(data.getDepartmentCode());
            data.setDepartmentName(department.getName());

            // 获取分公司
            Department company = departmentBO
                .getDepartment(data.getCompanyCode());
            data.setCompanyName(company.getName());
        }
        return data;
    }

    @Override
    public void checkLoginPwd(String userId, String loginPwd) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(loginPwd)) {
            SYSUser condition = new SYSUser();
            condition.setUserId(userId);
            condition.setLoginPwd(MD5Util.md5(loginPwd));
            long count = this.getTotalCount(condition);
            if (count != 1) {
                throw new BizException("jd00001", "原登录密码错误");
            }
        } else {
            throw new BizException("jd00001", "原登录密码错误");
        }
    }

    @Override
    public void refreshTeam(String userId, String teamCode, String updater) {
        if (StringUtils.isNotBlank(userId)) {
            SYSUser data = new SYSUser();
            data.setUserId(userId);
            data.setTeamCode(teamCode);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            sysUserDAO.updateTeam(data);
        }
    }
}
