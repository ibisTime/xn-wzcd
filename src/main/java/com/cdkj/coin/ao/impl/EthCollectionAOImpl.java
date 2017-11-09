package com.cdkj.coin.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.IEthCollectionAO;
import com.cdkj.coin.bo.IEthCollectionBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.EthCollection;

@Service
public class EthCollectionAOImpl implements IEthCollectionAO {

    @Autowired
    private IEthCollectionBO ethCollectionBO;

    @Override
    public Paginable<EthCollection> queryEthCollectionPage(int start,
            int limit, EthCollection condition) {
        return ethCollectionBO.getPaginable(start, limit, condition);
    }

    @Override
    public EthCollection getEthCollection(String code) {
        return ethCollectionBO.getEthCollection(code);
    }

}
