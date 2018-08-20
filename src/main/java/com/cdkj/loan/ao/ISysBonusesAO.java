package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SysBonuses;
import com.cdkj.loan.dto.req.XN632400Req;
import com.cdkj.loan.dto.req.XN632402Req;

@Component
public interface ISysBonusesAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addSysBonuses(XN632400Req req);

    public int dropSysBonuses(int id);

    public void editSysBonuses(XN632402Req req);

    public Paginable<SysBonuses> querySysBonusesPage(int start, int limit,
            SysBonuses condition);

    public List<SysBonuses> querySysBonusesList(SysBonuses condition);

    public SysBonuses getSysBonuses(int id);

}
