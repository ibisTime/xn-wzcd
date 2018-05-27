package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Province;

/**
 * 省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:06:28 
 * @history:
 */
public interface IProvinceAO {
    String DEFAULT_ORDER_COLUMN = "id";

    public int addProvince(String provinceNo, String name);

    public int dropProvince(int id);

    public int editProvince(int id, String provinceNo, String name);

    public Province getProvince(int id);

    public Paginable<Province> queryProvincePage(int start, int limit,
            Province condition);

    public List<Province> queryProvinceList(Province condition);
}
