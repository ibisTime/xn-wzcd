package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISaleUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SaleUser;

@Repository("saleUserDAOImpl")
public class SaleUserDAOImpl extends AMybatisTemplate implements ISaleUserDAO {

    // 注册
    @Override
    public int insert(SaleUser data) {
        return super.insert(NAMESPACE.concat("insert_saleUser"), data);
    }

    @Override
    public int delete(SaleUser data) {
        return 0;
    }

    @Override
    public SaleUser select(SaleUser condition) {
        return super.select(NAMESPACE.concat("select_saleUser"), condition,
            SaleUser.class);
    }

    @Override
    public long selectTotalCount(SaleUser condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_saleUser_count"),
            condition);
    }

    @Override
    public List<SaleUser> selectList(SaleUser condition) {
        return super.selectList(NAMESPACE.concat("select_saleUser"), condition,
            SaleUser.class);
    }

    @Override
    public List<SaleUser> selectList(SaleUser condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_saleUser"), start,
            count, condition, SaleUser.class);
    }

    @Override
    public int updateLoginPwd(SaleUser data) {
        return super.update(NAMESPACE.concat("update_login_pwd"), data);
    }

    @Override
    public int updateMobile(SaleUser data) {
        return super.update(NAMESPACE.concat("update_mobile"), data);
    }

    @Override
    public int updatePhoto(SaleUser data) {
        return super.update(NAMESPACE.concat("update_photo"), data);
    }

    @Override
    public int updateStatus(SaleUser data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public void updateRole(SaleUser data) {
        super.update(NAMESPACE.concat("update_role"), data);
    }

    @Override
    public void updateDepartment(SaleUser data) {
        super.update(NAMESPACE.concat("update_department"), data);
    }

}
