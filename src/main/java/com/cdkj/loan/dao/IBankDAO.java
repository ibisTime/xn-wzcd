package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Bank;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:28:46 
 * @history:
 */
public interface IBankDAO extends IBaseDAO<Bank> {
    String NAMESPACE = IBankDAO.class.getName().concat(".");

    public int updateBank(Bank data);
}
