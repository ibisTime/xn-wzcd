package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ContractImport;




public interface IContractImportBO extends IPaginableBO<ContractImport> {


	public String saveContractImport(ContractImport data);


	public int removeContractImport(String code);


	public int refreshContractImport(ContractImport data);


	public List<ContractImport> queryContractImportList(ContractImport condition);


	public ContractImport getContractImport(String code);


}