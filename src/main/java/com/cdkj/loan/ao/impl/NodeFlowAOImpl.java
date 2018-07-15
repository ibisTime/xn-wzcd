package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.INodeFlowAO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.NodeFlow;

@Service
public class NodeFlowAOImpl implements INodeFlowAO {

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public Paginable<NodeFlow> queryNodeFlowPage(int start, int limit,
            NodeFlow condition) {
        return nodeFlowBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<NodeFlow> queryNodeFlowList(NodeFlow condition) {
        return nodeFlowBO.queryNodeFlowList(condition);
    }

    @Override
    public NodeFlow getNodeFlow(String id) {
        return nodeFlowBO.getNodeFlow(id);
    }

}
