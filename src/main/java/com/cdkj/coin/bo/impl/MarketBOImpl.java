package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.dao.IMarketDAO;
import com.cdkj.coin.dao.ISYSConfigDAO;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.domain.SYSConfig;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Component
public class MarketBOImpl implements IMarketBO {

    @Autowired
    IMarketDAO marketDAO;

    @Autowired
    ISYSConfigDAO sysConfigDAO;

    @Override
    public Market standardMarket(ECoin coin) {

        Market avgCondition = new Market();
        avgCondition.setCoin(coin.getCode());
        BigDecimal avg = this.marketDAO.selectMarketAvg(avgCondition);
        avg = avg.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        if (avg == null) {
            throw new BizException("xn000", "行情加权值获取异常");
        }

        Market market = new Market();
        market.setMid(avg);
//        market.setAsk(avg);
//        market.setBid(avg);
//        market.setLastPrice(avg);
//        market.setLow(avg);
//        market.setHigh(avg);

        return market;
    }

    @Override
    public Market marketByCoinTypeAndOrigin(String coinType, String origin) {

        if (StringUtils.isBlank(coinType) || StringUtils.isBlank(origin)) {
            return null;
        }

        Market condition = new Market();
        condition.setOrigin(origin);
        condition.setCoin(coinType);
        return this.marketDAO.select(condition);

    }

    @Override
    public int updateMarket(String origin, String coinType, Market market) {

        market.setOrigin(origin);
        market.setCoin(coinType);
        return this.marketDAO.update(market);

    }

    @Override
    public List<Market> marketListByCondation(Market condation) {

        return this.marketDAO.selectList(condation);

    }


}
