package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.IMarketDAO;
import com.cdkj.coin.dao.base.ABaseDO;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;
import com.cdkj.coin.domain.Market;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Namespace;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Repository("marketDAOImpl")
public class MarketDAOImpl extends AMybatisTemplate implements IMarketDAO {

    @Override
    public int insert(Market data) {
        return 0;
    }

    @Override
    public int delete(Market data) {
        return 0;
    }

    @Override
    public long selectTotalCount(Market condition) {
        return 0;
    }

    @Override
    public Market select(Market condition) {

        return super.select(NAMESPACE.concat("selectedByCoinTypeAndOrigin"), condition, Market.class);

    }

    @Override
    public int update(Market market) {
        return super.update(NAMESPACE.concat("update"),market);
    }

    @Override
    public List<Market> selectList(Market condition, int start, int count) {
        return null;
    }

    @Override
    public List<Market> selectList(Market condition) {
        return null;
    }
}

