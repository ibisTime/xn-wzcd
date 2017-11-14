package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.AdsSell;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellDAO extends IBaseDAO<AdsSell> {

    String NAMESPACE = IAdsSellDAO.class.getName().concat(".");


}
