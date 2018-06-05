package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Contract;



//CHECK ��鲢��ע�� 
public interface IContractBO extends IPaginableBO<Contract> {


	public boolean isContractExist(String code);


	public String saveContract(Contract data);


	public int removeContract(String code);


	public int refreshContract(Contract data);


	public List<Contract> queryContractList(Contract condition);


	public Contract getContract(String code);


}