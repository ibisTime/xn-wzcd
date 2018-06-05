package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICheckProjectAO;
import com.cdkj.loan.bo.ICheckProjectBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CheckProject;

@Service
public class CheckProjectAOImpl implements ICheckProjectAO {

    @Autowired
    private ICheckProjectBO checkProjectBO;

    @Override
    public Paginable<CheckProject> queryCheckProjectPage(int start, int limit,
            CheckProject condition) {
        return checkProjectBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CheckProject> queryCheckProjectList(CheckProject condition) {
        return checkProjectBO.queryCheckProjectList(condition);
    }

    @Override
    public CheckProject getCheckProject(String code) {
        return checkProjectBO.getCheckProject(code);
    }
}
