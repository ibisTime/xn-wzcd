package com.cdkj.coin.ao;

import com.cdkj.coin.domain.Market;
import sun.jvm.hotspot.oops.Mark;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface IMarketAO {

    Market marketByCoinType(String coinType);

}
