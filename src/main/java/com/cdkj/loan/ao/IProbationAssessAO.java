package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ProbationAssess;

@Component
public interface IProbationAssessAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int addProbationAssess(ProbationAssess data);

    public int editProbationAssess(ProbationAssess data);

    public Paginable<ProbationAssess> queryProbationAssessPage(int start,
            int limit, ProbationAssess condition);

    public List<ProbationAssess> queryProbationAssessList(
            ProbationAssess condition);

    public ProbationAssess getProbationAssess(int id);

}
