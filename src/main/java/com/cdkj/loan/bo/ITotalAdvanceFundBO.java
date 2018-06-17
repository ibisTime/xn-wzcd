package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.TotalAdvanceFund;



//CHECK ��鲢��ע�� 
public interface ITotalAdvanceFundBO extends IPaginableBO<TotalAdvanceFund> {


	public boolean isTotalAdvanceFundExist(String code);


	public String saveTotalAdvanceFund(TotalAdvanceFund data);


	public int removeTotalAdvanceFund(String code);


	public int refreshTotalAdvanceFund(TotalAdvanceFund data);


	public List<TotalAdvanceFund> queryTotalAdvanceFundList(TotalAdvanceFund condition);


	public TotalAdvanceFund getTotalAdvanceFund(String code);


}