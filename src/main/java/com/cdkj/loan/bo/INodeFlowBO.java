package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.NodeFlow;

public interface INodeFlowBO extends IPaginableBO<NodeFlow> {

    // 列表查询
    public List<NodeFlow> queryNodeFlowList(NodeFlow condition);

    // 详情查询
    public NodeFlow getNodeFlow(String id);

    // 条件查询
    public NodeFlow getNodeFlow(String currentNode, String nextNode);

    // 根据当前节点获取节点流程
    public NodeFlow getNodeFlowByCurrentNode(String currentNode);

    // 更新参考清单
    public void refreshNodeFlow(String id, String fileList);
}
