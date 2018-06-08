package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Repoint;



//CHECK ��鲢��ע�� 
public interface IRepointBO extends IPaginableBO<Repoint> {


	public boolean isRepointExist(String code);


	public String saveRepoint(Repoint data);


	public int removeRepoint(String code);


	public int refreshRepoint(Repoint data);


	public List<Repoint> queryRepointList(Repoint condition);


	public Repoint getRepoint(String code);


}