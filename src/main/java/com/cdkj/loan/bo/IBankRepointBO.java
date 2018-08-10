package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankRepoint;



//CHECK ��鲢��ע�� 
public interface IBankRepointBO extends IPaginableBO<BankRepoint> {


	public boolean isBankRepointExist(String code);


	public String saveBankRepoint(BankRepoint data);


	public int removeBankRepoint(String code);


	public int refreshBankRepoint(BankRepoint data);


	public List<BankRepoint> queryBankRepointList(BankRepoint condition);


	public BankRepoint getBankRepoint(String code);


}