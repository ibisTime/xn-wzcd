package com.cdkj.loan.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.dao.IRoleNodeDAO;
import com.cdkj.loan.domain.RoleNode;

@Component
public class RoleNodeBOImpl implements IRoleNodeBO {

    protected static final Logger logger = LoggerFactory
        .getLogger(OrderBOImpl.class);

    @Autowired
    private IRoleNodeDAO roleNodeDAO;

    @Override
    public void assignNodeForRole(List<RoleNode> roleNodeList) {
        roleNodeDAO.insertRoleNodeList(roleNodeList);
    }

    @Override
    public List<RoleNode> queryNodeRoleListByRoleCode(String roleCode) {
        RoleNode condition = new RoleNode();
        condition.setRoleCode(roleCode);
        return roleNodeDAO.selectList(condition);
    }

}
