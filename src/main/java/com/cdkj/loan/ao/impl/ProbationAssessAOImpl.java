package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IProbationAssessAO;
import com.cdkj.loan.bo.IProbationAssessBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ProbationAssess;

@Service
public class ProbationAssessAOImpl implements IProbationAssessAO {

    @Autowired
    private IProbationAssessBO probationAssessBO;

    @Override
    public int addProbationAssess(ProbationAssess data) {
        return probationAssessBO.saveProbationAssess(data);
    }

    @Override
    public int editProbationAssess(ProbationAssess data) {
        return probationAssessBO.refreshProbationAssess(data);
    }

    @Override
    public Paginable<ProbationAssess> queryProbationAssessPage(int start,
            int limit, ProbationAssess condition) {
        return probationAssessBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ProbationAssess> queryProbationAssessList(
            ProbationAssess condition) {
        return probationAssessBO.queryProbationAssessList(condition);
    }

    @Override
    public ProbationAssess getProbationAssess(int id) {
        return probationAssessBO.getProbationAssess(id);
    }
}
