package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankSubbranch;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:07:32 
 * @history:
 */
public interface IBankSubbranchDAO extends IBaseDAO<BankSubbranch> {
    String NAMESPACE = IBankSubbranchDAO.class.getName().concat(".");

    public int updateBankSubbranch(BankSubbranch data);
}
