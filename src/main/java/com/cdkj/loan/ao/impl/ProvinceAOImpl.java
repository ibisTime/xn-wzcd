package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IProvinceAO;
import com.cdkj.loan.bo.IProvinceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Province;
import com.cdkj.loan.exception.BizException;

/**
 * 省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:12:13 
 * @history:
 */
@Service
public class ProvinceAOImpl implements IProvinceAO {

    @Autowired
    private IProvinceBO provinceBO;

    @Override
    public int addProvince(String provinceNo, String name) {
        Province data = new Province();
        data.setProvinceNo(provinceNo);
        data.setName(name);
        if (null != provinceBO.getProvince(data)) {
            throw new BizException("xn0000", "记录已存在，请勿重复添加。");
        }

        provinceBO.saveProvince(data);
        return provinceBO.getProvince(data).getId();
    }

    @Override
    public int dropProvince(int id) {
        Province condition = new Province();
        condition.setId(id);
        return provinceBO.dropProvince(condition);
    }

    @Override
    public int editProvince(int id, String provinceNo, String name) {
        Province data = new Province();
        data.setId(id);
        data.setProvinceNo(provinceNo);
        data.setName(name);

        return provinceBO.editProvince(data);
    }

    @Override
    public Province getProvince(int id) {
        Province condition = new Province();
        condition.setId(id);
        return provinceBO.getProvince(condition);
    }

    @Override
    public Paginable<Province> queryProvincePage(int start, int limit,
            Province condition) {
        return provinceBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Province> queryProvinceList(Province condition) {
        return provinceBO.queryProvinceList(condition);
    }
}
