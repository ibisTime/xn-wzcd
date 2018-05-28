package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.NodeFlow;

public interface INodeFlowDAO extends IBaseDAO<NodeFlow> {
    String NAMESPACE = INodeFlowDAO.class.getName().concat(".");
}
