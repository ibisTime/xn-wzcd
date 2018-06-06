package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IWelfareUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.WelfareUser;

/**
 * 福利发放人员
 * @author: silver 
 * @since: 2018年6月6日 下午8:18:12 
 * @history:
 */
@Repository("welfareUserDAOImpl")
public class WelfareUserDAOImpl extends AMybatisTemplate
        implements IWelfareUserDAO {

    @Override
    public int insert(WelfareUser data) {
        return super.insert(NAMESPACE.concat("insert_WelfareUser"), data);
    }

    @Override
    public int delete(WelfareUser data) {
        return super.delete(NAMESPACE.concat("delete_WelfareUser"), data);
    }

    @Override
    public WelfareUser select(WelfareUser condition) {
        return super.select(NAMESPACE.concat("select_WelfareUser"), condition,
            WelfareUser.class);
    }

    @Override
    public long selectTotalCount(WelfareUser condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_WelfareUser_count"), condition);
    }

    @Override
    public List<WelfareUser> selectList(WelfareUser condition) {
        return super.selectList(NAMESPACE.concat("select_WelfareUser"),
            condition, WelfareUser.class);
    }

    @Override
    public List<WelfareUser> selectList(WelfareUser condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_WelfareUser"), start,
            count, condition, WelfareUser.class);
    }

}
