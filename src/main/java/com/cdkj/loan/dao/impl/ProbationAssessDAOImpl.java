package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IProbationAssessDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ProbationAssess;

//CHECK 。。。 
@Repository("probationAssessDAOImpl")
public class ProbationAssessDAOImpl extends AMybatisTemplate
        implements IProbationAssessDAO {

    @Override
    public int insert(ProbationAssess data) {
        return super.insert(NAMESPACE.concat("insert_probationAssess"), data);
    }

    @Override
    public int delete(ProbationAssess data) {
        return super.delete(NAMESPACE.concat("delete_probationAssess"), data);
    }

    @Override
    public ProbationAssess select(ProbationAssess condition) {
        return super.select(NAMESPACE.concat("select_probationAssess"),
            condition, ProbationAssess.class);
    }

    @Override
    public long selectTotalCount(ProbationAssess condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_probationAssess_count"), condition);
    }

    @Override
    public List<ProbationAssess> selectList(ProbationAssess condition) {
        return super.selectList(NAMESPACE.concat("select_probationAssess"),
            condition, ProbationAssess.class);
    }

    @Override
    public List<ProbationAssess> selectList(ProbationAssess condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_probationAssess"),
            start, count, condition, ProbationAssess.class);
    }

    @Override
    public int update(ProbationAssess data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
