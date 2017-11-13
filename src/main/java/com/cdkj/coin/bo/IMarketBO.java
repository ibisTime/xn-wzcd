package com.cdkj.coin.bo;

import com.cdkj.coin.domain.Market;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketBO {

     public Market marketByCoinTypeAndOrigin(String coinType, String origin);

    int updateMarket(String origin,String cointType,Market market);

}
