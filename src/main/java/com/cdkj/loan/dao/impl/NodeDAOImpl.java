package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.INodeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Node;

@Repository("nodeDAOImpl")
public class NodeDAOImpl extends AMybatisTemplate implements INodeDAO {

    @Override
    public int insert(Node data) {
        return super.insert(NAMESPACE.concat("insert_node"), data);
    }

    @Override
    public int delete(Node data) {
        return super.delete(NAMESPACE.concat("delete_node"), data);
    }

    @Override
    public Node select(Node condition) {
        return super.select(NAMESPACE.concat("select_node"), condition,
            Node.class);
    }

    @Override
    public long selectTotalCount(Node condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_node_count"),
            condition);
    }

    @Override
    public List<Node> selectList(Node condition) {
        return super.selectList(NAMESPACE.concat("select_node"), condition,
            Node.class);
    }

    @Override
    public List<Node> selectList(Node condition, int start, int count) {

        return super.selectList(NAMESPACE.concat("select_node"), start, count,
            condition, Node.class);

    }

    @Override
    public List<Node> selectNodeListIncludeCurRole(Node node) {

        return super.selectList(
            NAMESPACE.concat("select_nodeList_include_curRole"), node,
            Node.class);
    }

}
