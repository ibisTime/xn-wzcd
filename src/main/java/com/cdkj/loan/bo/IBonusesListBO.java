package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BonusesList;

public interface IBonusesListBO extends IPaginableBO<BonusesList> {

    public String saveBonusesList(BonusesList data);

    public List<BonusesList> queryBonusesListList(BonusesList condition);

    public BonusesList getBonusesList(String code);

}
