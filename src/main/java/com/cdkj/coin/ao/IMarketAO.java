package com.cdkj.coin.ao;

import com.cdkj.coin.domain.Market;
import com.cdkj.coin.domain.MarketDetail;
import com.cdkj.coin.dto.req.XN625291Req;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketAO {

    //获取价格计算标准的行情
    List<Market> marketByCoin(List<String> coinList);

    //获取列表行情
    List<Market> marketListByReq(XN625291Req req);

    //获取平台干预后的，货币价格
    Market coinPriceByPlatform(String coin);

    // 获取包含各个币种的行情
    List<MarketDetail> marketDetailList();

}
