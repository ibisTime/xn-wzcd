package com.cdkj.coin.bo;

import com.cdkj.coin.api.impl.XN625291;
import com.cdkj.coin.domain.Market;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketBO {

    public Market marketByCoinTypeAndOrigin(String coinType, String origin);

    int updateMarket(String origin,String cointType,Market market);

    List<Market> marketListByCondation(Market condation);
    
}
