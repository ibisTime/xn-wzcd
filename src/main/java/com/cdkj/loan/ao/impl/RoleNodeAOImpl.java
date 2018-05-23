package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRoleNodeAO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.domain.RoleNode;

@Service
public class RoleNodeAOImpl implements IRoleNodeAO {

    @Autowired
    private IRoleNodeBO roleNodeBO;

    @Override
    public void assignNodeForRole(String roleCode, List<String> nodeList) {
        // 批量删除之前节点

        // 批量新增节点
        List<RoleNode> roleNodeList = new ArrayList<RoleNode>();
        for (int i = 0; i > nodeList.size(); i++) {
            String nodeCode = (String) nodeList.get(i);
            RoleNode roleNode = new RoleNode();
            roleNode.setRoleCode(roleCode);
            roleNode.setNodeCode(nodeCode);
            roleNodeList.add(roleNode);
        }
        roleNodeBO.assignNodeForRole(roleNodeList);
    }

    @Override
    public List<RoleNode> queryNodeRoleListByRoleCode(String roleCode) {
        return roleNodeBO.queryNodeRoleListByRoleCode(roleCode);
    }

}
