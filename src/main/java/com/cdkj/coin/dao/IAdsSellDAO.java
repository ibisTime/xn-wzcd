package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.AdsSell;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellDAO extends IBaseDAO<AdsSell> {

    String NAMESPACE = IAdsSellDAO.class.getName().concat(".");

    public long selectFrontTotalCount(AdsSell condition);
    public AdsSell selectFront(AdsSell condition);
    public List<AdsSell> selectFrontList(AdsSell condition);
    public List<AdsSell> selectFrontList(AdsSell condition, int start, int count);

    public int updateByPrimaryKeySelective(AdsSell condition);
    public int updateByPrimaryKey(AdsSell condition);


}
