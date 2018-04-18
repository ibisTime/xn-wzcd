package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSMenu;
import com.cdkj.loan.domain.SYSMenuRole;

/**
 * 角色菜单
 * @author: Gejin 
 * @since: 2016年4月16日 下午10:24:53 
 * @history:
 */
public interface ISYSMenuRoleDAO extends IBaseDAO<SYSMenuRole> {
    String NAMESPACE = ISYSMenuRoleDAO.class.getName().concat(".");

    public List<SYSMenu> selectSYSMenuList(SYSMenuRole data);

    public int deleteSYSMenuList(SYSMenuRole data);
}
