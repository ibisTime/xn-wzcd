package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RoleNode;

public interface IRoleNodeDAO extends IBaseDAO<RoleNode> {
    String NAMESPACE = IRoleNodeDAO.class.getName().concat(".");

    public void insertRoleNodeList(List<RoleNode> nodeList);

    public void deleteRoleNodeList(RoleNode data);

}
