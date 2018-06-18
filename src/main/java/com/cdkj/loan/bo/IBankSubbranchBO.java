package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankSubbranch;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:14:07 
 * @history:
 */
public interface IBankSubbranchBO extends IPaginableBO<BankSubbranch> {
    public String saveBankSubbranch(BankSubbranch data);

    public int dropBankSubbranch(BankSubbranch data);

    public BankSubbranch getBankSubbranch(String code);

    public long getBankSubbranchMaxid(String bankCode);

    public int editBankSubbranch(BankSubbranch data);

    public List<BankSubbranch> queryBankSubbranchList(BankSubbranch condition);
}
