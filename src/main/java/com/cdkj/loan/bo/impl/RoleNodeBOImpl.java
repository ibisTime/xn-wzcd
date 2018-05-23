package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IRoleNodeDAO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RoleNode;

@Component
public class RoleNodeBOImpl extends PaginableBOImpl<RoleNode> implements
        IRoleNodeBO {

    @Autowired
    private IRoleNodeDAO roleNodeDAO;

    @Override
    public void assignNodeForRole(List<RoleNode> roleNodeList) {
        roleNodeDAO.insertRoleNodeList(roleNodeList);
    }

    @Override
    public List<Node> queryNodeListByRoleCode(String roleCode) {
        RoleNode condition = new RoleNode();
        condition.setRoleCode(roleCode);
        return roleNodeDAO.selectNodeListByRole(condition);
    }

}
