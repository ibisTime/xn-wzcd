package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.INodeFlowDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.NodeFlow;

@Repository("nodeFlowDAOImpl")
public class NodeFlowDAOImpl extends AMybatisTemplate implements INodeFlowDAO {

    @Override
    public int insert(NodeFlow data) {
        return super.insert(NAMESPACE.concat("insert_nodeFlow"), data);
    }

    @Override
    public int delete(NodeFlow data) {
        return super.delete(NAMESPACE.concat("delete_nodeFlow"), data);
    }

    @Override
    public int updateFileList(NodeFlow data) {
        return super.update(NAMESPACE.concat("update_fileList"), data);
    }

    @Override
    public NodeFlow select(NodeFlow condition) {
        return super.select(NAMESPACE.concat("select_nodeFlow"), condition,
            NodeFlow.class);
    }

    @Override
    public long selectTotalCount(NodeFlow condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_nodeFlow_count"), condition);
    }

    @Override
    public List<NodeFlow> selectList(NodeFlow condition) {
        return super.selectList(NAMESPACE.concat("select_nodeFlow"), condition,
            NodeFlow.class);
    }

    @Override
    public List<NodeFlow> selectList(NodeFlow condition, int start, int count) {

        return super.selectList(NAMESPACE.concat("select_nodeFlow"), start,
            count, condition, NodeFlow.class);

    }
}
