package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ProbationAssess;

public interface IProbationAssessBO extends IPaginableBO<ProbationAssess> {

    public int saveProbationAssess(ProbationAssess data);

    public int removeProbationAssess(int id);

    public int refreshProbationAssess(ProbationAssess data);

    public List<ProbationAssess> queryProbationAssessList(
            ProbationAssess condition);

    public ProbationAssess getProbationAssess(int id);

}
