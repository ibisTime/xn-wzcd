package com.cdkj.coin.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.coin.dao.ISYSMenuRoleDAO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;

@Repository("sysMenuRoleDAOImpl")
public class SYSMenuRoleDAOImpl extends AMybatisTemplate implements
        ISYSMenuRoleDAO {

    @Override
    public int insert(SYSMenuRole data) {
        return super.insert(NAMESPACE.concat("insert_sysMenuRole"), data);
    }

    @Override
    public int delete(SYSMenuRole data) {
        return super.delete(NAMESPACE.concat("delete_sysMenuRole"), data);
    }

    @Override
    public SYSMenuRole select(SYSMenuRole condition) {
        return super.select("select_sysMenuRole", condition, SYSMenuRole.class);
    }

    @Override
    public long selectTotalCount(SYSMenuRole condition) {
        return super.selectTotalCount("select_sysMenuRole_count", condition);
    }

    @Override
    public List<SYSMenuRole> selectList(SYSMenuRole condition) {
        return super.selectList("select_sysMenuRole", condition,
            SYSMenuRole.class);
    }

    @Override
    public List<SYSMenuRole> selectList(SYSMenuRole condition, int start,
            int count) {
        return super.selectList("select_sysMenuRole", start, count, condition,
            SYSMenuRole.class);
    }

    @Override
    public List<SYSMenu> selectSYSMenuList(SYSMenuRole data) {
        return super.selectList(NAMESPACE.concat("select_sysMenu_list"), data,
            SYSMenu.class);
    }

    @Override
    public int deleteSYSMenuList(SYSMenuRole data) {
        return super.delete("delete_sysMenuRoleList", data);
    }
}
