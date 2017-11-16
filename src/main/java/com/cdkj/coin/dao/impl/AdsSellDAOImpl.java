package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.IAdsSellDAO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;
import com.cdkj.coin.domain.Ads;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
@Repository("adsSellDAOImpl")
public class AdsSellDAOImpl extends AMybatisTemplate implements IAdsSellDAO {

    @Override
    public int insert(Ads data) {

        return super.insert(NAMESPACE.concat("insert"), data);

    }

    //
    @Override
    public int delete(Ads data) {
        return 0;
    }

    //
    @Override
    public long selectTotalCount(Ads condition) {
        return 0;
    }

    //
    @Override
    public Ads select(Ads condition) {
        return super.select(NAMESPACE.concat("select"), condition, Ads.class);
    }

    //
    @Override
    public List<Ads> selectList(Ads condition) {

        return super.selectList(NAMESPACE.concat("select"), condition, Ads.class);

    }

    //
    @Override
    public List<Ads> selectList(Ads condition, int start, int limit) {

        return super.selectList(NAMESPACE.concat("select"), start, limit, condition, Ads.class);

    }

    @Override
    public int updateByPrimaryKeySelective(Ads condition) {

        return super.update(NAMESPACE.concat("updateByPrimaryKeySelective"),condition);

    }

    @Override
    public int updateByPrimaryKey(Ads condition) {
        return super.update(NAMESPACE.concat("updateByPrimaryKey"),condition);

    }

    //  前端
    @Override
    public Ads selectFront(Ads condition) {

        return super.select(NAMESPACE.concat("selectFront"), condition, Ads.class);

    }

    @Override
    public long selectFrontTotalCount(Ads condition) {

        return super.selectTotalCount(NAMESPACE.concat("selectFrontTotalCount"), condition);

    }

    @Override
    public List<Ads> selectFrontList(Ads condition) {

        return super.selectList(NAMESPACE.concat("selectFront"), condition, Ads.class);

    }

    @Override
    public List<Ads> selectFrontList(Ads condition, int start, int limit) {

        return super.selectList(NAMESPACE.concat("selectFront"), start, limit, condition, Ads.class);

    }
}
