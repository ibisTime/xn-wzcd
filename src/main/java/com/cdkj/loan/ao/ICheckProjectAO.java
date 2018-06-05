package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CheckProject;

@Component
public interface ICheckProjectAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<CheckProject> queryCheckProjectPage(int start, int limit,
            CheckProject condition);

    public List<CheckProject> queryCheckProjectList(CheckProject condition);

    public CheckProject getCheckProject(String code);

}
