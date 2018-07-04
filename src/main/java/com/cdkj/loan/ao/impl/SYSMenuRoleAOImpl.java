package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ISYSMenuRoleAO;
import com.cdkj.loan.bo.ISYSMenuBO;
import com.cdkj.loan.bo.ISYSMenuRoleBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.domain.SYSMenu;
import com.cdkj.loan.domain.SYSMenuRole;
import com.cdkj.loan.exception.BizException;

@Service
public class SYSMenuRoleAOImpl implements ISYSMenuRoleAO {

    @Autowired
    ISYSMenuRoleBO sysMenuRoleBO;

    @Autowired
    ISYSMenuBO sysMenuBO;

    @Autowired
    ISYSRoleBO sysRoleBO;

    @Override
    @Transactional
    public int addSYSMenuRole(SYSMenuRole data) {
        int count = 0;
        if (!sysRoleBO.isSYSRoleExist(data.getRoleCode())) {
            throw new BizException("lh0000", "角色不存在！");
        }
        // 删除角色所关联的菜单
        sysMenuRoleBO.removeSYSMenuList(data.getRoleCode());
        // 重新分配角色菜单
        if (CollectionUtils.isNotEmpty(data.getMenuCodeList())) {
            for (String sysMenuCode : data.getMenuCodeList()) {
                if (!sysMenuBO.isSYSMenuExist(sysMenuCode)) {
                    throw new BizException("lh0000", "[" + sysMenuCode
                            + "]菜单不存在！");
                }
                SYSMenuRole sysMenuRole = new SYSMenuRole();
                sysMenuRole.setMenuCode(sysMenuCode);
                sysMenuRole.setRoleCode(data.getRoleCode());
                sysMenuRole.setUpdater(data.getUpdater());
                sysMenuRole.setUpdateDatetime(new Date());
                sysMenuRole.setRemark(data.getRemark());
                count += sysMenuRoleBO.saveSYSMenuRole(sysMenuRole);
            }
        }
        return count;
    }

    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenuRole data) {
        return sysMenuRoleBO.querySYSMenuList(data);
    }

}
