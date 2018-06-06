package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AssertGoods;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:55:07 
 * @history:
 */
public interface IAssertGoodsDAO extends IBaseDAO<AssertGoods> {
    String NAMESPACE = IAssertGoodsDAO.class.getName().concat(".");

    public int update(AssertGoods data);
}
