package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.EthCollection;

public interface IEthCollectionBO extends IPaginableBO<EthCollection> {

    public String saveEthCollection(String from, String to, BigDecimal value,
            String txHash);

    public List<EthCollection> queryEthCollectionList(EthCollection condition);

    public EthCollection getEthCollection(String code);

    public EthCollection getEthCollectionByTxHash(String txHash);

    public int colectionNotice(EthCollection data, BigDecimal txfee,
            Date ethDatetime);

}
