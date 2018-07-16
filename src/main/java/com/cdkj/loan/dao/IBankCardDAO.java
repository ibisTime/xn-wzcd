package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Bankcard;

/**
 * @author: haiqingzheng 
 * @since: 2018年5月13日 下午7:36:22 
 * @history:
 */
public interface IBankCardDAO extends IBaseDAO<Bankcard> {

    String NAMESPACE = IBankCardDAO.class.getName().concat(".");

    public int update(Bankcard data);

    public void updateBankcardNumber(Bankcard bankcard);

}
