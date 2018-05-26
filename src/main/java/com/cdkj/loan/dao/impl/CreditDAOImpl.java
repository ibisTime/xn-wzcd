package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Credit;

@Repository("creditDAOImpl")
public class CreditDAOImpl extends AMybatisTemplate implements ICreditDAO {

    // 新增
    @Override
    public int insert(Credit data) {

        return super.insert(NAMESPACE.concat("insert_credit"), data);
    }

    // 删除
    @Override
    public int delete(Credit data) {
        // TODO Auto-generated method stub
        return 0;
    }

    // 查询
    @Override
    public Credit select(Credit condition) {

        return super.select(NAMESPACE.concat("select_credit"), condition,
            Credit.class);
    }

    // 查询总数 (按角色权限查询)
    @Override
    public long selectTotalCount(Credit condition) {

        return super.selectTotalCount(NAMESPACE.concat("select_credit_count"),
            condition);
    }

    // 列表查询 （ 按角色权限查的 ps：列表查不用权限 以后改）
    @Override
    public List<Credit> selectList(Credit condition) {

        return super.selectList(NAMESPACE.concat("select_credit_PagingQuery"),
            condition, Credit.class);
    }

    // 分页查询 （按角色权限查的）
    @Override
    public List<Credit> selectList(Credit condition, int start, int count) {

        return super.selectList(NAMESPACE.concat("select_credit_PagingQuery"),
            start, count, condition, Credit.class);
    }

    // 更新 修改征信用
    @Override
    public int updateCredit(Credit credit) {

        return super.update(NAMESPACE.concat("update_credit"), credit);

    }

    // 更新征信单节点
    @Override
    public int updateNode(Credit credit) {

        return super.update(NAMESPACE.concat("update_node"), credit);
    }

}
