package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IRoleNodeAO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;

/**
 * 角色节点
 * @author: jiafr 
 * @since: 2018年5月24日 下午2:34:09 
 * @history:
 */
@Service
public class RoleNodeAOImpl implements IRoleNodeAO {

    @Autowired
    private IRoleNodeBO roleNodeBO;

    @Autowired
    private INodeBO nodeBO;

    // 批量分配节点
    @Override
    @Transactional
    public void assignNodeForRole(String roleCode, List<String> nodeList) {
        // 批量删除节点
        roleNodeBO.deleteNodeByRole(roleCode);

        // 批量新增节点
        List<RoleNode> roleNodeList = new ArrayList<RoleNode>();
        for (int i = 0; i < nodeList.size(); i++) {
            String nodeCode = nodeList.get(i);
            RoleNode roleNode = new RoleNode();
            roleNode.setRoleCode(roleCode);
            roleNode.setNodeCode(nodeCode);
            roleNodeList.add(roleNode);
        }
        roleNodeBO.insertNodeForRole(roleNodeList);
    }

    @Override
    public List<Node> queryNodeListByRoleCode(String roleCode) {
        return roleNodeBO.queryNodeListByRoleCode(roleCode);
    }

    @Override
    public List<Node> queryNodeListIncludeCurRoleCode(String roleCode) {
        Node node = new Node();
        node.setRoleCode(roleCode);
        return nodeBO.queryNodeListIncludeCurRole(node);
    }
}
