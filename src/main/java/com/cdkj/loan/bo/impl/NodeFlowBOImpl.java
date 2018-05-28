package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.INodeFlowDAO;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class NodeFlowBOImpl extends PaginableBOImpl<NodeFlow> implements
        INodeFlowBO {

    @Autowired
    INodeFlowDAO nodeFlowDAO;

    @Override
    public List<NodeFlow> queryNodeFlowList(NodeFlow condition) {
        return nodeFlowDAO.selectList(condition);
    }

    @Override
    public NodeFlow getNodeFlow(String id) {
        NodeFlow data = null;
        if (StringUtils.isNotBlank(id)) {
            NodeFlow condition = new NodeFlow();
            condition.setId(id);
            data = nodeFlowDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "流程节点不存在！");
            }
        }
        return data;
    }

    @Override
    public NodeFlow getNodeFlowByCurrentNode(String currentNode) {
        NodeFlow data = null;
        if (StringUtils.isNotBlank(currentNode)) {
            NodeFlow condition = new NodeFlow();
            condition.setCurrentNode(currentNode);
            List<NodeFlow> flowList = nodeFlowDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(flowList)) {
                data = flowList.get(0);
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "流程节点尚未配置！");
            }
        }
        return data;
    }
}
