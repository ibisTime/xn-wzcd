package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:54:13 
 * @history:
 */
@Repository("iCreditUserDAOImpl")
public class ICreditUserDAOImpl extends AMybatisTemplate implements
        ICreditUserDAO {

    @Override
    public int insert(Department data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Department data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Department select(Department condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long selectTotalCount(Department condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Department> selectList(Department condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> selectList(Department condition, int start,
            int count) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void insertCreditUserList(List<CreditUser> list) {

        super.insertBatch(NAMESPACE.concat("insert_creditUserList"),
            (List) list);

    }

}
