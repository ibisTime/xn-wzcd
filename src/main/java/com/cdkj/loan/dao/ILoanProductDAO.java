package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.LoanProduct;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:23:19 
 * @history:
 */
public interface ILoanProductDAO extends IBaseDAO<LoanProduct> {
    String NAMESPACE = ILoanProductDAO.class.getName().concat(".");

    public void updateLoanProduct(LoanProduct data);

    public void updateLoanProductPublish(LoanProduct data);
}
