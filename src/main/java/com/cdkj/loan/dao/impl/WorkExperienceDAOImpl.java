package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IWorkExperienceDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.WorkExperience;

@Repository("workExperienceDAOImpl")
public class WorkExperienceDAOImpl extends AMybatisTemplate implements
        IWorkExperienceDAO {

    @Override
    public int insert(WorkExperience data) {
        return super.insert(NAMESPACE.concat("insert_workExperience"), data);
    }

    @Override
    public int delete(WorkExperience data) {
        return super.delete(NAMESPACE.concat("delete_workExperience"), data);
    }

    @Override
    public WorkExperience select(WorkExperience condition) {
        return super.select(NAMESPACE.concat("select_workExperience"),
            condition, WorkExperience.class);
    }

    @Override
    public long selectTotalCount(WorkExperience condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_workExperience_count"), condition);
    }

    @Override
    public List<WorkExperience> selectList(WorkExperience condition) {
        return super.selectList(NAMESPACE.concat("select_workExperience"),
            condition, WorkExperience.class);
    }

    @Override
    public List<WorkExperience> selectList(WorkExperience condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_workExperience"),
            start, count, condition, WorkExperience.class);
    }

}
