package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RecruitApply;

public interface IRecruitApplyBO extends IPaginableBO<RecruitApply> {

    public boolean isRecruitApplyExist(String code);

    public String saveRecruitApply(RecruitApply data);

    public void auditRecruitApply(RecruitApply condition);

    public List<RecruitApply> queryRecruitApplyList(RecruitApply condition);

    public RecruitApply getRecruitApply(String code);

}
