package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISysBonusesAO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISysBonusesBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SysBonuses;
import com.cdkj.loan.dto.req.XN632400Req;
import com.cdkj.loan.dto.req.XN632402Req;

@Service
public class SysBonusesAOImpl implements ISysBonusesAO {

    @Autowired
    private ISysBonusesBO sysBonusesBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public void addSysBonuses(XN632400Req req) {
        SysBonuses data = new SysBonuses();
        data.setIsSelfDevelop(req.getIsSelfDevelop());
        data.setUnitPrice(StringValidater.toLong(req.getUnitPrice()));
        data.setMonthRate(StringValidater.toDouble(req.getMonthRate()));
        data.setRetainMonths(StringValidater.toInteger(req.getRetainMonths()));
        data.setStartAmount(StringValidater.toLong(req.getStartAmount()));
        data.setEndAmount(StringValidater.toLong(req.getEndAmount()));
        data.setUpdater(req.getUpdater());
        data.setUpdaterDatetime(new Date());
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
        data.setUpdater(req.getUpdater());
        data.setUpdaterDatetime(new Date());
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
        Paginable<SysBonuses> paginable = sysBonusesBO.getPaginable(start,
            limit, condition);
        for (SysBonuses sysBonuses : paginable.getList()) {
            if (StringUtils.isNotBlank(sysBonuses.getUpdater())) {
                SYSUser user = sysUserBO.getUser(sysBonuses.getUpdater());
                sysBonuses.setUpdaterName(user.getRealName());
            }
        }
        return paginable;
    }

    @Override
    public List<SysBonuses> querySysBonusesList(SysBonuses condition) {
        List<SysBonuses> querySysBonusesList = sysBonusesBO
            .querySysBonusesList(condition);
        for (SysBonuses sysBonuses : querySysBonusesList) {
            if (StringUtils.isNotBlank(sysBonuses.getUpdater())) {
                SYSUser user = sysUserBO.getUser(sysBonuses.getUpdater());
                sysBonuses.setUpdaterName(user.getRealName());
            }
        }
        return querySysBonusesList;
    }

    @Override
    public SysBonuses getSysBonuses(int id) {
        SysBonuses sysBonuses = sysBonusesBO.getSysBonuses(id);
        if (StringUtils.isNotBlank(sysBonuses.getUpdater())) {
            SYSUser user = sysUserBO.getUser(sysBonuses.getUpdater());
            sysBonuses.setUpdaterName(user.getRealName());
        }
        return sysBonuses;
    }
}
