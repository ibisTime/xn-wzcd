package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IOverdueTreatmentAO;
import com.cdkj.loan.bo.IOverdueTreatmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OverdueTreatment;

@Service
public class OverdueTreatmentAOImpl implements IOverdueTreatmentAO {

    @Autowired
    private IOverdueTreatmentBO overdueTreatmentBO;

    @Override
    public String addOverdueTreatment(OverdueTreatment data) {
        return overdueTreatmentBO.saveOverdueTreatment(data);
    }

    @Override
    public int editOverdueTreatment(OverdueTreatment data) {
        return overdueTreatmentBO.refreshOverdueTreatment(data);
    }

    @Override
    public int dropOverdueTreatment(String code) {
        return overdueTreatmentBO.removeOverdueTreatment(code);
    }

    @Override
    public Paginable<OverdueTreatment> queryOverdueTreatmentPage(int start,
            int limit, OverdueTreatment condition) {
        return overdueTreatmentBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<OverdueTreatment> queryOverdueTreatmentList(
            OverdueTreatment condition) {
        return overdueTreatmentBO.queryOverdueTreatmentList(condition);
    }

    @Override
    public OverdueTreatment getOverdueTreatment(String code) {
        return overdueTreatmentBO.getOverdueTreatment(code);
    }
}
