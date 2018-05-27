package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Province;

/**
 * 省份编号
 * @author: silver 
 * @since: 2018年5月26日 下午5:50:22 
 * @history:
 */
public interface IProvinceBO extends IPaginableBO<Province> {
    public int saveProvince(Province data);

    public int dropProvince(Province data);

    public Province getProvince(Province condition);

    public int editProvince(Province data);

    public List<Province> queryProvinceList(Province condition);
}
