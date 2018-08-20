package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BonusesList;

@Component
public interface IBonusesListAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBonusesList(BonusesList data);

    public Paginable<BonusesList> queryBonusesListPage(int start, int limit,
            BonusesList condition);

    public List<BonusesList> queryBonusesListList(BonusesList condition);

    public BonusesList getBonusesList(String code);

}
