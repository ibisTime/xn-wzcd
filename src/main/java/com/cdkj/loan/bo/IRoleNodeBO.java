package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.domain.RoleNode;

public interface IRoleNodeBO {

    public void assignNodeForRole(List<RoleNode> nodeList);

    public List<RoleNode> queryNodeRoleListByRoleCode(String roleCode);

}
