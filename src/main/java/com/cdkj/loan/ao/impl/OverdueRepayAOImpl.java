package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IOverdueRepayAO;
import com.cdkj.loan.bo.IOverdueRepayBO;
import com.cdkj.loan.domain.OverdueRepay;

@Service
public class OverdueRepayAOImpl implements IOverdueRepayAO {

    @Autowired
    private IOverdueRepayBO overdueRepayBO;

    @Override
    public List<OverdueRepay> queryOverdueRepayList(OverdueRepay condition) {
        return overdueRepayBO.queryOverdueRepayList(condition);
    }
}
