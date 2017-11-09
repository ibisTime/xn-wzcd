package com.cdkj.coin.ao;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.EthCollection;

public interface IEthCollectionAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<EthCollection> queryEthCollectionPage(int start,
            int limit, EthCollection condition);

    public EthCollection getEthCollection(String code);

}
