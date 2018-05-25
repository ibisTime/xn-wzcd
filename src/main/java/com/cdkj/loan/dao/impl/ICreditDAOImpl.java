package com.cdkj.loan.dao.impl;

import java.util.List;

import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Credit;

public class ICreditDAOImpl extends AMybatisTemplate implements ICreditDAO {

    @Override
    public int insert(Credit data) {

        return super.insert(NAMESPACE.concat("insert_credit"), data);
    }

    @Override
    public int delete(Credit data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Credit select(Credit condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long selectTotalCount(Credit condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Credit> selectList(Credit condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Credit> selectList(Credit condition, int start, int count) {
        // TODO Auto-generated method stub
        return null;
    }

}
