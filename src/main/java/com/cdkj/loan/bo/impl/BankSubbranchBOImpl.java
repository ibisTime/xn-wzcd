package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IBankSubbranchDAO;
import com.cdkj.loan.domain.BankSubbranch;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:17:01 
 * @history:
 */
@Component
public class BankSubbranchBOImpl extends PaginableBOImpl<BankSubbranch>
        implements IBankSubbranchBO {

    @Autowired
    private IBankSubbranchDAO bankSubbranchDAO;

    @Override
    public int saveBankSubbranch(BankSubbranch data) {
        return bankSubbranchDAO.insert(data);
    }

    @Override
    public int dropBankSubbranch(BankSubbranch data) {
        return bankSubbranchDAO.delete(data);
    }

    @Override
    public BankSubbranch getBankSubbranch(BankSubbranch condition) {
        return bankSubbranchDAO.select(condition);
    }

    @Override
    public int editBankSubbranch(BankSubbranch data) {
        return bankSubbranchDAO.updateBankSubbranch(data);
    }

    @Override
    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition) {
        return bankSubbranchDAO.selectList(condition);
    }

}
