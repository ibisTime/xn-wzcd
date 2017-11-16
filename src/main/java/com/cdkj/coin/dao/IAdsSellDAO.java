package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.Ads;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsSellDAO extends IBaseDAO<Ads> {

    String NAMESPACE = IAdsSellDAO.class.getName().concat(".");

    public long selectFrontTotalCount(Ads condition);
    public Ads selectFront(Ads condition);
    public List<Ads> selectFrontList(Ads condition);
    public List<Ads> selectFrontList(Ads condition, int start, int count);

    public int updateByPrimaryKeySelective(Ads condition);
    public int updateByPrimaryKey(Ads condition);


}
