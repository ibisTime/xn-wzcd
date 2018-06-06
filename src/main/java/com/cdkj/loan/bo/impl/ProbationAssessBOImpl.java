package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IProbationAssessBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IProbationAssessDAO;
import com.cdkj.loan.domain.ProbationAssess;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class ProbationAssessBOImpl extends PaginableBOImpl<ProbationAssess>
        implements IProbationAssessBO {

    @Autowired
    private IProbationAssessDAO probationAssessDAO;

    public int saveProbationAssess(ProbationAssess data) {
        if (data != null) {
            probationAssessDAO.insert(data);
        }
        return data.getId();
    }

    @Override
    public int removeProbationAssess(int id) {
        int count = 0;
        if (id != 0) {
            ProbationAssess data = new ProbationAssess();
            data.setId(id);
            count = probationAssessDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshProbationAssess(ProbationAssess data) {
        int count = 0;
        if (data.getId() != 0) {
            count = probationAssessDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ProbationAssess> queryProbationAssessList(
            ProbationAssess condition) {
        return probationAssessDAO.selectList(condition);
    }

    @Override
    public ProbationAssess getProbationAssess(int id) {
        ProbationAssess data = null;
        if (id != 0) {
            ProbationAssess condition = new ProbationAssess();
            condition.setId(id);
            data = probationAssessDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "评估编号不存在！");
            }
        }
        return data;
    }
}
