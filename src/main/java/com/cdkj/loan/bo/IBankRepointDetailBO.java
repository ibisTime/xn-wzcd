package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankRepointDetail;



//CHECK ��鲢��ע�� 
public interface IBankRepointDetailBO extends IPaginableBO<BankRepointDetail> {


	public boolean isBankRepointDetailExist(String code);


	public String saveBankRepointDetail(BankRepointDetail data);


	public int removeBankRepointDetail(String code);


	public int refreshBankRepointDetail(BankRepointDetail data);


	public List<BankRepointDetail> queryBankRepointDetailList(BankRepointDetail condition);


	public BankRepointDetail getBankRepointDetail(String code);


}