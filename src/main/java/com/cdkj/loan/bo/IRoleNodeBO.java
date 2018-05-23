package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;

public interface IRoleNodeBO extends IPaginableBO<RoleNode> {

    public void assignNodeForRole(List<RoleNode> nodeList);

    // 根据角色查询节点
    public List<Node> queryNodeListByRoleCode(String roleCode);

}
