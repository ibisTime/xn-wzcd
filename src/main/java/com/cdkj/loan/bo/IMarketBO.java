package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.domain.Market;
import com.cdkj.loan.enums.ECoin;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketBO {

    /*
     获取价格计算的标准,
     取加权值 + 系统可配参数
    * */
    public Market standardMarket(ECoin coin);

    public Market marketByCoinTypeAndOrigin(String coinType, String origin);

    int updateMarket(String origin,String cointType,Market market);

    List<Market> marketListByCondation(Market condation);

//    BigDecimal getMarketAVG(ECoin coin);
    
}
