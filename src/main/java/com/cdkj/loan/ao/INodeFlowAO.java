package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.NodeFlow;

@Component
public interface INodeFlowAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public Paginable<NodeFlow> queryNodeFlowPage(int start, int limit,
            NodeFlow condition);

    public List<NodeFlow> queryNodeFlowList(NodeFlow condition);

    public NodeFlow getNodeFlow(String id);

    public void doModifyFileList(String id, List<String> fileList);

}
