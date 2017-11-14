package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.IAdsSellDAO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;
import com.cdkj.coin.domain.AdsSell;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
@Repository("adsSellDAOImpl")
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
        return super.select(NAMESPACE.concat("select"),condition,AdsSell.class);
    }
    //
    @Override
    public List<AdsSell> selectList(AdsSell condition) {

        return super.selectList(NAMESPACE.concat("select"),condition,AdsSell.class);

    }
    //
    @Override
    public List<AdsSell> selectList(AdsSell condition, int start, int limit) {

        return super.selectList(NAMESPACE.concat("select"),start,limit,condition,AdsSell.class);

    }

//  前端
    @Override
    public AdsSell selectFront(AdsSell condition) {

        return super.select(NAMESPACE.concat("selectFront"),condition,AdsSell.class);

    }

    @Override
    public long selectFrontTotalCount(AdsSell condition) {

        return super.selectTotalCount(NAMESPACE.concat("selectFrontTotalCount"),condition);

    }

    @Override
    public List<AdsSell> selectFrontList(AdsSell condition) {

        return super.selectList(NAMESPACE.concat("selectFront"),condition,AdsSell.class);

    }

    @Override
    public List<AdsSell> selectFrontList(AdsSell condition, int start, int limit) {

        return super.selectList(NAMESPACE.concat("selectFront"),start,limit,condition,AdsSell.class);

    }
}
