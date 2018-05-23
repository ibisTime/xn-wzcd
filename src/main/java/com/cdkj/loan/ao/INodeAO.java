package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Node;

@Component
public interface INodeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 新增
    public String addNode(Node data);

    // 删除
    public int dropNode(String code);

    // 修改
    public int editNode(Node data);

    // 分页查询
    public Paginable<Node> queryNodePage(int start, int limit, Node condition);

    // 列表查询
    public List<Node> queryNodeList(Node condition);

    // 详情查询
    public Node getNode(String code);

}
