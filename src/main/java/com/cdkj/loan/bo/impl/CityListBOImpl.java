package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICityListBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ICityListDAO;
import com.cdkj.loan.domain.CityList;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class CityListBOImpl extends PaginableBOImpl<CityList>
        implements ICityListBO {

    @Autowired
    private ICityListDAO cityListDAO;

    public void saveCityList(CityList data) {
        cityListDAO.insert(data);
    }

    @Override
    public void removeCityList(CityList data) {
        cityListDAO.delete(data);
    }

    @Override
    public List<CityList> queryCityListList(CityList condition) {
        return cityListDAO.selectList(condition);
    }

    @Override
    public CityList getCityList(int id) {
        CityList data = null;
        if (id != 0) {
            CityList condition = new CityList();
            condition.setId(id);
            data = cityListDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "城市列表编号不存在！");
            }
        }
        return data;
    }
}
