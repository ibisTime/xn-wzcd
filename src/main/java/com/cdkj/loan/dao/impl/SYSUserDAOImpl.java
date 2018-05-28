package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISYSUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SYSUser;

@Repository("sysUserDAOImpl")
public class SYSUserDAOImpl extends AMybatisTemplate implements ISYSUserDAO {

    @Override
    public int insert(SYSUser data) {
        return super.insert(NAMESPACE.concat("insert_sysUser"), data);
    }

    @Override
    public int delete(SYSUser data) {
        return super.delete(NAMESPACE.concat("delete_sysUser"), data);
    }

    @Override
    public SYSUser select(SYSUser condition) {
        return super.select(NAMESPACE.concat("select_sysUser"), condition,
            SYSUser.class);
    }

    @Override
    public long selectTotalCount(SYSUser condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sysUser_count"),
            condition);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition) {
        return super.selectList(NAMESPACE.concat("select_sysUser"), condition,
            SYSUser.class);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sysUser"), start,
            count, condition, SYSUser.class);
    }

    @Override
    public void updateStatus(SYSUser data) {
        super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public void updateRole(SYSUser data) {
        super.update(NAMESPACE.concat("update_role"), data);
    }

    @Override
    public void updatePost(SYSUser data) {
        super.update(NAMESPACE.concat("update_post"), data);
    }

    @Override
    public void updateLoginPwd(SYSUser data) {
        super.update(NAMESPACE.concat("update_login_pwd"), data);
    }

    @Override
    public void updateMobile(SYSUser data) {
        super.update(NAMESPACE.concat("update_mobile"), data);
    }

    @Override
    public void updatePhoto(SYSUser data) {
        super.update(NAMESPACE.concat("update_sysUser_photo"), data);
    }

}
