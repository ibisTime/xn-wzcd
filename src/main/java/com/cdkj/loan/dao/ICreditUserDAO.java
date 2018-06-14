package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:46:20 
 * @history:
 */
public interface ICreditUserDAO extends IBaseDAO<CreditUser> {

    String NAMESPACE = ICreditUserDAO.class.getName().concat(".");

    // 修改征信人员信息
    public void updateCreditUser(CreditUser creditUser);

    // 录入银行征信结果
    public void inputBankCreditResult(CreditUser creditUser);

    // 修改征信人员收入情况
    public void updateCreditUserIncome(CreditUser creditUser);

}
