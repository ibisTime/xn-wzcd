package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.bo.ISYSMenuRoleBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Service
public class SYSRoleAOImpl implements ISYSRoleAO {

    @Autowired
    ISYSRoleBO sysRoleBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    ISYSMenuRoleBO sysMenuRoleBO;

    @Override
    public String addSYSRole(SYSRole data) {
        if (data != null) {
            sysRoleBO.saveSYSRole(data);
        } else {
            throw new BizException("lh4000", "角色编号已经存在！");
        }
        return data.getCode();
    }

    @Override
    @Transactional
    public boolean dropSYSRole(String roleCode) {
        if (!sysRoleBO.isSYSRoleExist(roleCode)) {
            throw new BizException("lh4000", "角色不存在！");
        }
        SYSUser condition = new SYSUser();
        condition.setRoleCode(roleCode);
        List<SYSUser> list = sysUserBO.queryUserList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            throw new BizException("lh4000", "该角色已在使用，无法删除！");
        }
        // 删除角色和角色菜单关联表
        sysRoleBO.removeSYSRole(roleCode);
        sysMenuRoleBO.removeSYSMenuList(roleCode);
        return true;
    }

    @Override
    public boolean editSYSRole(SYSRole data) {
        if (data != null && sysRoleBO.isSYSRoleExist(data.getCode())) {
            sysRoleBO.refreshSYSRole(data);
        } else {
            throw new BizException("lh4000", "角色不存在！");
        }
        return true;
    }

    @Override
    public List<SYSRole> querySYSRoleList(SYSRole condition) {
        List<SYSRole> sysRoleList = sysRoleBO.querySYSRoleList(condition);
        for (SYSRole sysRole : sysRoleList) {
            initRole(sysRole);
        }
        return sysRoleList;
    }

    @Override
    public Paginable<SYSRole> querySYSRolePage(int start, int limit,
            SYSRole condition) {
        Paginable<SYSRole> paginable = sysRoleBO.getPaginable(start, limit,
            condition);
        for (SYSRole sysRole : paginable.getList()) {
            initRole(sysRole);
        }
        return paginable;
    }

    /** 
     * @see com.std.user.ao.ISYSRoleAO#getSYSRole(java.lang.String)
     */
    @Override
    public SYSRole getSYSRole(String code) {
        if (!sysRoleBO.isSYSRoleExist(code)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "角色不存在！");
        }
        SYSRole sysRole = sysRoleBO.getSYSRole(code);
        initRole(sysRole);
        return sysRole;
    }

    private void initRole(SYSRole sysRole) {
        if (StringUtils.isNotBlank(sysRole.getUpdater())) {
            SYSUser user = sysUserBO.getUser(sysRole.getUpdater());
            sysRole.setUpdaterName(user.getRealName());
        }
    }

}
