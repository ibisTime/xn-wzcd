package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ArchiveLocation;



//CHECK ��鲢��ע�� 
public interface IArchiveLocationBO extends IPaginableBO<ArchiveLocation> {


	public boolean isArchiveLocationExist(String code);


	public String saveArchiveLocation(ArchiveLocation data);


	public int removeArchiveLocation(String code);


	public int refreshArchiveLocation(ArchiveLocation data);


	public List<ArchiveLocation> queryArchiveLocationList(ArchiveLocation condition);


	public ArchiveLocation getArchiveLocation(String code);


}