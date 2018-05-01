package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ProductOrder;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IProductOrderDAO extends IBaseDAO<ProductOrder> {
    String NAMESPACE = IProductOrderDAO.class.getName().concat(".");
}
