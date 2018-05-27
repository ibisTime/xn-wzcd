package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IProvinceBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IProvinceDAO;
import com.cdkj.loan.domain.Province;

@Component
public class ProvinceBOImpl extends PaginableBOImpl<Province>
        implements IProvinceBO {

    @Autowired
    private IProvinceDAO provinceDAO;

    @Override
    public int saveProvince(Province data) {
        return provinceDAO.insert(data);
    }

    @Override
    public int dropProvince(Province data) {
        return provinceDAO.delete(data);
    }

    @Override
    public Province getProvince(Province condition) {
        return provinceDAO.select(condition);
    }

    @Override
    public int editProvince(Province data) {
        return provinceDAO.updateProvince(data);
    }

    @Override
    public List<Province> queryProvinceList(Province condition) {
        return provinceDAO.selectList(condition);
    }
}
