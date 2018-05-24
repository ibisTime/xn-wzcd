package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;

public interface IRoleNodeBO extends IPaginableBO<RoleNode> {

    // 批量新增节点给角色
    public void insertNodeForRole(List<RoleNode> nodeList);

    // 根据角色查询节点
    public List<Node> queryNodeListByRoleCode(String roleCode);

    // 根据角色批量删除节点
    public void deleteNodeByRole(String roleCode);

}
