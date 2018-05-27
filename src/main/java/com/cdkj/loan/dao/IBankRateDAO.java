package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankRate;

/**
 * 利率明细
 * @author: silver 
 * @since: 2018年5月27日 下午4:28:46 
 * @history:
 */
public interface IBankRateDAO extends IBaseDAO<BankRate> {
    String NAMESPACE = IBankRateDAO.class.getName().concat(".");

    public int updateBankRate(BankRate data);
}
