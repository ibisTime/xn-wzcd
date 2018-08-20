package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SysBonuses;

public interface ISysBonusesBO extends IPaginableBO<SysBonuses> {

    public void saveSysBonuses(SysBonuses data);

    public int removeSysBonuses(int id);

    public void refreshSysBonuses(SysBonuses data);

    public List<SysBonuses> querySysBonusesList(SysBonuses condition);

    public SysBonuses getSysBonuses(int id);

}
