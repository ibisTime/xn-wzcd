package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CityList;
import com.cdkj.loan.dto.req.XN630440Req;

@Component
public interface ICityListAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addCityList(CityList data);

    public Paginable<CityList> queryCityListPage(int start, int limit,
            CityList condition);

    public List<CityList> queryCityListList(CityList condition);

    public CityList getCityList(int id);

    // 城市列表刷新
    public void refreshCityList(XN630440Req req);

}
