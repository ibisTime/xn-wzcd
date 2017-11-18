package com.cdkj.coin.ao;

import java.util.List;

import com.cdkj.coin.domain.Market;
import com.cdkj.coin.dto.req.XN625291Req;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketAO {

    //获取价格计算标准的行情
    List<Market> marketByCoin(List<String> coinList);

    //获取列表行情
    List<Market> marketListByReq(XN625291Req req);

}
