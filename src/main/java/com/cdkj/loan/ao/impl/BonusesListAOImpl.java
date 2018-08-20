package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBonusesListAO;
import com.cdkj.loan.bo.IBonusesListBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BonusesList;

@Service
public class BonusesListAOImpl implements IBonusesListAO {

    @Autowired
    private IBonusesListBO bonusesListBO;

    @Override
    public String addBonusesList(BonusesList data) {
        return bonusesListBO.saveBonusesList(data);
    }

    @Override
    public Paginable<BonusesList> queryBonusesListPage(int start, int limit,
            BonusesList condition) {
        return bonusesListBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BonusesList> queryBonusesListList(BonusesList condition) {
        return bonusesListBO.queryBonusesListList(condition);
    }

    @Override
    public BonusesList getBonusesList(String code) {
        return bonusesListBO.getBonusesList(code);
    }
}
