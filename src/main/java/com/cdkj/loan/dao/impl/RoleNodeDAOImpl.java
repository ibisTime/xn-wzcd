package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRoleNodeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RoleNode;

@Repository("roleNodeDAOImpl")
public class RoleNodeDAOImpl extends AMybatisTemplate implements IRoleNodeDAO {

    @Override
    public int insert(RoleNode data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(RoleNode data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RoleNode select(RoleNode condition) {
        return super.select(NAMESPACE.concat("select_roleNode"), condition,
            RoleNode.class);
    }

    @Override
    public long selectTotalCount(RoleNode condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_roleNode_count"), condition);
    }

    @Override
    public List<RoleNode> selectList(RoleNode condition) {
        return super.selectList(NAMESPACE.concat("select_roleNode"), condition,
            RoleNode.class);
    }

    @Override
    public List<RoleNode> selectList(RoleNode condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_roleNode"), start,
            count, condition, RoleNode.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void insertRoleNodeList(List<RoleNode> nodeList) {
        super.insertBatch(NAMESPACE.concat("insert_roleNodeList"),
            (List) nodeList);
    }

    @Override
    public void deleteRoleNodeList(RoleNode data) {
        super.delete(NAMESPACE.concat("delete_roleNodeList"), data);
    }
}
