package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.req.XN632002Req;

@Component
public interface ICollectBankcardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCollectBankcard(XN632000Req req);

    public int dropCollectBankcard(String code);

    public int editCollectBankcard(XN632002Req req);

    public Paginable<CollectBankcard> queryCollectBankcardPage(int start,
            int limit, CollectBankcard condition);

    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition);

    public CollectBankcard getCollectBankcard(String code);

}
