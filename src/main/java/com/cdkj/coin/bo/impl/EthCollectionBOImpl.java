package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IEthCollectionBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IEthCollectionDAO;
import com.cdkj.coin.domain.EthCollection;
import com.cdkj.coin.enums.EEthCollectionStatus;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.exception.BizException;

@Component
public class EthCollectionBOImpl extends PaginableBOImpl<EthCollection>
        implements IEthCollectionBO {

    @Autowired
    private IEthCollectionDAO ethCollectionDAO;

    @Override
    public String saveEthCollection(String from, String to, BigDecimal value,
            String txHash) {
        String code = null;
        EthCollection data = new EthCollection();
        code = OrderNoGenerater.generate(EGeneratePrefix.Collection.getCode());
        data.setCode(code);
        data.setFromAddress(from);
        data.setToAddress(to);
        data.setAmount(value);
        data.setTxHash(txHash);
        data.setStatus(EEthCollectionStatus.Broadcast.getCode());
        data.setCreateDatetime(new Date());
        ethCollectionDAO.insert(data);
        return code;
    }

    @Override
    public List<EthCollection> queryEthCollectionList(EthCollection condition) {
        return ethCollectionDAO.selectList(condition);
    }

    @Override
    public EthCollection getEthCollection(String code) {
        EthCollection data = null;
        if (StringUtils.isNotBlank(code)) {
            EthCollection condition = new EthCollection();
            condition.setCode(code);
            data = ethCollectionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "归集记录不存在");
            }
        }
        return data;
    }

    @Override
    public EthCollection getEthCollectionByTxHash(String txHash) {
        EthCollection condition = new EthCollection();
        condition.setTxHash(txHash);
        List<EthCollection> results = ethCollectionDAO.selectList(condition);
        if (CollectionUtils.isEmpty(results)) {
            throw new BizException("xn0000", "归集记录不存在");
        }
        return results.get(0);
    }

    @Override
    public int colectionNotice(EthCollection data, BigDecimal txfee,
            Date ethDatetime) {
        int count = 0;
        data.setTxFee(txfee);
        data.setStatus(EEthCollectionStatus.Broadcast_YES.getCode());
        data.setEthDatetime(ethDatetime);
        data.setUpdateDatetime(new Date());
        return count;
    }
}
