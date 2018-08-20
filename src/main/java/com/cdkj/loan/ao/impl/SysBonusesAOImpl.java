package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISysBonusesAO;
import com.cdkj.loan.bo.ISysBonusesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SysBonuses;
import com.cdkj.loan.dto.req.XN632400Req;
import com.cdkj.loan.dto.req.XN632402Req;

@Service
public class SysBonusesAOImpl implements ISysBonusesAO {

    @Autowired
    private ISysBonusesBO sysBonusesBO;

    @Override
    public void addSysBonuses(XN632400Req req) {
        SysBonuses data = new SysBonuses();
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setUnitPrice(StringValidater.toLong(req.getUnitPrice()));
        data.setMonthRate(StringValidater.toDouble(req.getMonthRate()));
        data.setRetainMonths(StringValidater.toInteger(req.getRetainMonths()));
        data.setStartAmount(StringValidater.toLong(req.getStartAmount()));
        data.setEndAmount(StringValidater.toLong(req.getEndAmount()));
        data.setRemark(req.getRemark());
        sysBonusesBO.saveSysBonuses(data);
    }

    @Override
    public void editSysBonuses(XN632402Req req) {
        SysBonuses data = sysBonusesBO
            .getSysBonuses(StringValidater.toInteger(req.getId()));
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setUnitPrice(StringValidater.toLong(req.getUnitPrice()));
        data.setMonthRate(StringValidater.toDouble(req.getMonthRate()));
        data.setRetainMonths(StringValidater.toInteger(req.getRetainMonths()));
        data.setStartAmount(StringValidater.toLong(req.getStartAmount()));
        data.setEndAmount(StringValidater.toLong(req.getEndAmount()));
        data.setRemark(req.getRemark());
        sysBonusesBO.refreshSysBonuses(data);
    }

    @Override
    public int dropSysBonuses(int id) {
        return sysBonusesBO.removeSysBonuses(id);
    }

    @Override
    public Paginable<SysBonuses> querySysBonusesPage(int start, int limit,
            SysBonuses condition) {
        return sysBonusesBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SysBonuses> querySysBonusesList(SysBonuses condition) {
        return sysBonusesBO.querySysBonusesList(condition);
    }

    @Override
    public SysBonuses getSysBonuses(int id) {
        return sysBonusesBO.getSysBonuses(id);
    }
}
