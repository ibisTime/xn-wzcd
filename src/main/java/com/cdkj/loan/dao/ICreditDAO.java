package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Credit;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:34:13 
 * @history:
 */
public interface ICreditDAO extends IBaseDAO<Credit> {

    String NAMESPACE = ICreditDAO.class.getName().concat(".");

    // 修改征信
    public int updateCredit(Credit credit);

    // 更新征信单节点
    public int updateNode(Credit credit);

}
