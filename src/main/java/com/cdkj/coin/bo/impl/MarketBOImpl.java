package com.cdkj.coin.bo.impl;

import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.common.StringUtil;
import com.cdkj.coin.dao.IMarketDAO;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.enums.EMarketOrigin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Component
public class MarketBOImpl implements IMarketBO {

    @Autowired
    IMarketDAO marketDAO;

    @Override
    public Market marketByCoinTypeAndOrigin(String coinType, String origin) {

        if (StringUtils.isBlank(coinType) || StringUtils.isBlank(origin)) {
            return null;
        }

        Market condation = new Market();
        condation.setOrigin(origin);
        condation.setCoin(coinType);
       return this.marketDAO.select(condation);

    }

    @Override
    public int updateMarket(String origin, String coinType, Market market) {
        market.setOrigin(origin);
        market.setCoin(coinType);
        return this.marketDAO.update(market);
    }
}
