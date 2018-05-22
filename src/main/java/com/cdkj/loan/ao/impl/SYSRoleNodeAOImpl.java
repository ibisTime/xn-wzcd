package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ISYSRoleNodeAO;
import com.cdkj.loan.bo.ISYSRoleNodeBO;

@Service
public class SYSRoleNodeAOImpl implements ISYSRoleNodeAO {

    @Autowired
    private ISYSRoleNodeBO sysRoleNodeBO;

    @Override
    @Transactional
    public void assignNodeForRole(String roleCode, List<String> nodeList) {

        sysRoleNodeBO.assignNodeForRole(roleCode, nodeList);

    }
}
