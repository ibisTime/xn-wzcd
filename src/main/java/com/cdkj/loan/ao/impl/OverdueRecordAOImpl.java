package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IOverdueRecordAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IOverdueRecordBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.OverdueRecord;

@Service
public class OverdueRecordAOImpl implements IOverdueRecordAO {

    @Autowired
    private IOverdueRecordBO overdueRecordBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    public int addOverdueRecord(OverdueRecord data) {
        return overdueRecordBO.saveOverdueRecord(data);
    }

    @Override
    public Paginable<OverdueRecord> queryOverdueRecordPage(int start, int limit,
            OverdueRecord condition) {
        Paginable<OverdueRecord> paginable = overdueRecordBO.getPaginable(start,
            limit, condition);
        for (OverdueRecord overdueRecord : paginable.getList()) {
            initOverdueRecord(overdueRecord);
        }
        return paginable;
    }

    private void initOverdueRecord(OverdueRecord overdueRecord) {
        if (StringUtils.isNotBlank(overdueRecord.getBizCode())) {
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(overdueRecord.getBizCode());
            overdueRecord.setGhRealName(budgetOrder.getGhRealName());
            overdueRecord.setGuarantor1Name(budgetOrder.getGuarantor1Name());
            overdueRecord.setGuarantor2Name(budgetOrder.getGuarantor2Name());
        }
    }

    @Override
    public List<OverdueRecord> queryOverdueRecordList(OverdueRecord condition) {
        return overdueRecordBO.queryOverdueRecordList(condition);
    }

    @Override
    public OverdueRecord getOverdueRecord(int id) {
        return overdueRecordBO.getOverdueRecord(id);
    }
}
