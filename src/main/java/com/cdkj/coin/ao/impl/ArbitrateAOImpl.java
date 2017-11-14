package com.cdkj.coin.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IArbitrateAO;
import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.Arbitrate;

@Service
public class ArbitrateAOImpl implements IArbitrateAO {

    @Autowired
    private IArbitrateBO arbitrateBO;

    @Override
    public Paginable<Arbitrate> queryArbitratePage(int start, int limit,
            Arbitrate condition) {
        return arbitrateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Arbitrate> queryArbitrateList(Arbitrate condition) {
        return arbitrateBO.queryArbitrateList(condition);
    }

    @Override
    public Arbitrate getArbitrate(String code) {
        return arbitrateBO.getArbitrate(code);
    }
}
