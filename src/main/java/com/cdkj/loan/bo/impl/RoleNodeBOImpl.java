package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IRoleNodeDAO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;

/**
 * 角色节点
 * @author: jiafr 
 * @since: 2018年5月24日 下午12:47:40 
 * @history:
 */
@Component
public class RoleNodeBOImpl extends PaginableBOImpl<RoleNode> implements
        IRoleNodeBO {

    @Autowired
    private IRoleNodeDAO roleNodeDAO;

    // 根据角色批量删除节点
    @Override
    public void deleteNodeByRole(String roleCode) {

        RoleNode roleNode = new RoleNode();
        roleNode.setRoleCode(roleCode);

        roleNodeDAO.deleteRoleNodeList(roleNode);

    }

    // 批量新增节点给角色
    @Override
    public void insertNodeForRole(List<RoleNode> roleNodeList) {
        roleNodeDAO.insertRoleNodeList(roleNodeList);
    }

    // 根据角色编号查询节点列表
    @Override
    public List<Node> queryNodeListByRoleCode(String roleCode) {
        RoleNode condition = new RoleNode();
        condition.setRoleCode(roleCode);
        return roleNodeDAO.selectNodeListByRole(condition);
    }

}
