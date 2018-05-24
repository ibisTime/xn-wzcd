package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Node;

public interface INodeBO extends IPaginableBO<Node> {

    // 新增
    public String saveNode(Node data);

    // 删除
    public int removeNode(String code);

    // 修改
    public int refreshNode(Node data);

    // 列表查询
    public List<Node> queryNodeList(Node condition);

    // 详情查询
    public Node getNode(String code);

    // 查询所有节点列表（包含当前角色）
    public List<Node> queryNodeListIncludeCurRole(Node node);

}
