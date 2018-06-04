package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RecruitApply;



//CHECK ��鲢��ע�� 
public interface IRecruitApplyBO extends IPaginableBO<RecruitApply> {


	public boolean isRecruitApplyExist(String code);


	public String saveRecruitApply(RecruitApply data);


	public int removeRecruitApply(String code);


	public int refreshRecruitApply(RecruitApply data);


	public List<RecruitApply> queryRecruitApplyList(RecruitApply condition);


	public RecruitApply getRecruitApply(String code);


}