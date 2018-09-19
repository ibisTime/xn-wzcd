package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IOverdueTreatmentAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IOverdueTreatmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OverdueTreatment;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.SYSUser;

@Service
public class OverdueTreatmentAOImpl implements IOverdueTreatmentAO {

    @Autowired
    private IOverdueTreatmentBO overdueTreatmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IRepayPlanAO repayPlanAO;

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
        Paginable<OverdueTreatment> paginable = overdueTreatmentBO
            .getPaginable(start, limit, condition);
        for (OverdueTreatment overdueTreatment : paginable.getList()) {
            initOverdueTreatment(overdueTreatment);
        }
        return paginable;
    }

    @Override
    public List<OverdueTreatment> queryOverdueTreatmentList(
            OverdueTreatment condition) {
        return overdueTreatmentBO.queryOverdueTreatmentList(condition);
    }

    @Override
    public OverdueTreatment getOverdueTreatment(String code) {
        OverdueTreatment overdueTreatment = overdueTreatmentBO
            .getOverdueTreatment(code);
        RepayPlan repayPlan = repayPlanAO
            .getRepayPlan(overdueTreatment.getRepayPlanCode());
        overdueTreatment.setRepayPlan(repayPlan);
        initOverdueTreatment(overdueTreatment);
        return overdueTreatment;
    }

    private void initOverdueTreatment(OverdueTreatment overdueTreatment) {
        if (StringUtils.isNotBlank(overdueTreatment.getOperator())) {
            SYSUser user = sysUserBO.getUser(overdueTreatment.getOperator());
            overdueTreatment.setOperatorName(user.getRealName());
        }
    }
}
