package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CUser;
import com.cdkj.loan.domain.User;

@Repository("CuserDAOImpl")
public class CuserDAOImpl extends AMybatisTemplate implements ICUserDAO {

    @Override
    public int insert(CUser data) {
        return super.insert(NAMESPACE.concat("insert_cuser"), data);
    }

    @Override
    public int update(User data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public CUser select(CUser condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long selectTotalCount(CUser condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<CUser> selectList(CUser condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CUser> selectList(CUser condition, int start, int count) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateLoginPwd(User data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateRole(User data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(CUser data) {
        return 0;
    }

}
