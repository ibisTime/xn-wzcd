package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.IAdsSellDAO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;
import com.cdkj.coin.domain.AdsSell;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class AdsSellDAOImpl extends AMybatisTemplate implements IAdsSellDAO {

    @Override
    public int insert(AdsSell data) {

      return super.insert(NAMESPACE.concat("insert"),data);

    }

    //
    @Override
    public int delete(AdsSell data) {
        return 0;
    }

    //
    @Override
    public long selectTotalCount(AdsSell condition) {
        return 0;
    }

    //
    @Override
    public AdsSell select(AdsSell condition) {
        return null;
    }

    //
    @Override
    public List<AdsSell> selectList(AdsSell condition) {
        return null;
    }

    //
    @Override
    public List<AdsSell> selectList(AdsSell condition, int start, int count) {
        return null;
    }
}
