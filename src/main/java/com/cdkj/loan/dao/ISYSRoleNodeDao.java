package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSRoleNode;

public interface ISYSRoleNodeDao extends IBaseDAO<SYSRoleNode> {
    String NAMESPACE = ISYSMenuRoleDAO.class.getName().concat(".");

    public void assignNodeForRole(String roleCode, List<String> nodeList);

}
