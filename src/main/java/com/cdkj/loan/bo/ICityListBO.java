package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CityList;

public interface ICityListBO extends IPaginableBO<CityList> {

    public void saveCityList(CityList data);

    public void removeCityList(CityList data);

    public List<CityList> queryCityListList(CityList condition);

    public CityList getCityList(int id);

}
