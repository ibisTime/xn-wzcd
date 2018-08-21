package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.PerformanceBond;

@Component
public interface IPerformanceBondAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addPerformanceBond(PerformanceBond data);

    public void editPerformanceBond(String budgetCode);

    public Paginable<PerformanceBond> queryPerformanceBondPage(int start,
            int limit, PerformanceBond condition);

    public List<PerformanceBond> queryPerformanceBondList(
            PerformanceBond condition);

    public PerformanceBond getPerformanceBond(int id);

}
