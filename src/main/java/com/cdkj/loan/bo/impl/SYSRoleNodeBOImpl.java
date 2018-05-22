package com.cdkj.loan.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.bo.ISYSRoleNodeBO;
import com.cdkj.loan.dao.ISYSRoleNodeDao;

public class SYSRoleNodeBOImpl implements ISYSRoleNodeBO {

    protected static final Logger logger = LoggerFactory
        .getLogger(OrderBOImpl.class);

    @Autowired
    private ISYSRoleNodeDao sysRoleNodeDao;

    @Override
    public void assignNodeForRole(String roleCode, List<String> nodeList) {

        sysRoleNodeDao.assignNodeForRole(roleCode, nodeList);

    }

}
