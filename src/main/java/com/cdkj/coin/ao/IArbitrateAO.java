package com.cdkj.coin.ao;

import java.util.List;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Arbitrate;

public interface IArbitrateAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<Arbitrate> queryArbitratePage(int start, int limit,
            Arbitrate condition);

    public List<Arbitrate> queryArbitrateList(Arbitrate condition);

    public Arbitrate getArbitrate(String code);

}
