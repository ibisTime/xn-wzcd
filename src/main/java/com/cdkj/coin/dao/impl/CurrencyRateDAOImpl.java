package com.cdkj.coin.dao.impl;

import com.cdkj.coin.dao.ICurrencyRateDAO;
import com.cdkj.coin.domain.CurrencyRate;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.cdkj.coin.dao.base.support.AMybatisTemplate;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Repository("currencyRateDAOImpl")
public class CurrencyRateDAOImpl extends AMybatisTemplate implements ICurrencyRateDAO {

    @Override
    public int insert(CurrencyRate data) {

        return super.insert(NAMESPACE.concat("insert"), data);

    }

    @Override
    public int update(CurrencyRate currencyRate) {

        return super.update(NAMESPACE.concat("update"), currencyRate);

    }

    @Override
    public long selectTotalCount(CurrencyRate condition) {
        return 0;
    }

    @Override
    public int delete(CurrencyRate data) {
        return 0;
    }

    @Override
    public CurrencyRate select(CurrencyRate condition) {

        return super.select(NAMESPACE.concat("select"), condition, CurrencyRate.class);

    }

    @Override
    public List<CurrencyRate> selectList(CurrencyRate condition) {

        return super.selectList(NAMESPACE.concat("selectList"), condition, CurrencyRate.class);

    }

    @Override
    public List<CurrencyRate> selectList(CurrencyRate condition, int start, int count) {
        return null;
    }

}
