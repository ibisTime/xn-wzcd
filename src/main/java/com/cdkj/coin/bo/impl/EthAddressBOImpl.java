package com.cdkj.coin.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.dao.IEthAddressDAO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressStatus;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.exception.BizException;

@Component
public class EthAddressBOImpl extends PaginableBOImpl<EthAddress> implements
        IEthAddressBO {

    @Autowired
    private IEthAddressDAO ethAddressDAO;

    @Override
    public int saveEthAddress(EEthAddressType type, String userId,
            String address, String password) {
        int count = 0;
        Date now = new Date();
        EthAddress data = new EthAddress();
        data.setType(type.getCode());
        data.setAddress(address);
        data.setPassword(password);
        data.setUserId(userId);
        data.setStatus(EEthAddressStatus.NORMAL.getCode());
        data.setCreateDatetime(now);
        data.setUpdateDatetime(now);
        count = ethAddressDAO.insert(data);
        return count;
    }

    @Override
    public List<EthAddress> queryEthAddressList(EthAddress condition) {
        return ethAddressDAO.selectList(condition);
    }

    @Override
    public List<EthAddress> queryMEthAddressList() {
        EthAddress condition = new EthAddress();
        condition.setType(EEthAddressType.M.getCode());
        condition.setStatus(EEthAddressStatus.NORMAL.getCode());
        return ethAddressDAO.selectList(condition);
    }

    @Override
    public EthAddress getEthAddress(Long id) {
        EthAddress data = null;
        if (id != null) {
            EthAddress condition = new EthAddress();
            condition.setId(id);
            data = ethAddressDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "以太坊地址不存在");
            }
        }
        return data;
    }

    @Override
    public EthAddress getEthAddress(EEthAddressType type, String address) {
        EthAddress data = null;
        EthAddress condition = new EthAddress();
        condition.setType(type.getCode());
        condition.setAddress(address);
        List<EthAddress> results = ethAddressDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(results)) {
            data = results.get(0);
        }
        return data;
    }

    @Override
    public EthAddress getEthAddressByUserId(String userId) {
        EthAddress data = null;
        EthAddress condition = new EthAddress();
        condition.setUserId(userId);
        List<EthAddress> results = ethAddressDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(results)) {
            data = results.get(0);
        }
        return data;
    }

}
