package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Node;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月24日 下午4:59:04 
 * @history:
 */
public interface INodeDAO extends IBaseDAO<Node> {
    String NAMESPACE = INodeDAO.class.getName().concat(".");

    public List<Node> selectNodeListIncludeCurRole(Node node);

}
