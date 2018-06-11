package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.domain.OverdueRepay;

@Component
public interface IOverdueRepayAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public List<OverdueRepay> queryOverdueRepayList(OverdueRepay condition);
}
