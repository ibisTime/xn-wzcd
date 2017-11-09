package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.common.RandomUtil;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IEthAddressDAO;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.enums.EEthAddressStatus;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.eth.EthAccount;
import com.cdkj.coin.eth.Web3JClient;
import com.cdkj.coin.exception.BizException;

@Component
public class EthAddressBOImpl extends PaginableBOImpl<EthAddress> implements
        IEthAddressBO {

    private static Logger logger = Logger.getLogger(EthAddressBOImpl.class);

    private static Web3j web3j = Web3JClient.getClient();

    @Autowired
    private IEthAddressDAO ethAddressDAO;

    @Override
    public String generateAddress(EEthAddressType type, String ethAccountName,
            String userId, Date availableDatetimeStart,
            Date availableDatetimeEnd) {
        String address = null;
        String password = RandomUtil.generate8();
        EthAccount account = new EthAccount();
        address = account.createAccount(ethAccountName, password, null);
        logger.info("以太坊账户创建成功:" + address);
        if (StringUtils.isBlank(address)) {
            throw new BizException("xn625000", "以太坊账户创建失败，请检查节点是否正常！");
        }
        this.saveEthAddress(type, userId, address, password, BigDecimal.ZERO,
            availableDatetimeStart, availableDatetimeEnd);
        return address;
    }

    @Override
    public String saveEthAddress(EEthAddressType type, String userId,
            String address, String password, BigDecimal balance,
            Date availableDatetimeStart, Date availableDatetimeEnd) {
        String code = OrderNoGenerater.generate("ETH");
        Date now = new Date();
        EthAddress data = new EthAddress();
        data.setCode(code);
        data.setType(type.getCode());
        data.setAddress(address);
        data.setPassword(password);
        data.setUserId(userId);
        data.setBalance(balance);
        data.setAvailableDatetimeStart(availableDatetimeStart);
        data.setAvailableDatetimeEnd(availableDatetimeEnd);
        data.setStatus(EEthAddressStatus.NORMAL.getCode());
        data.setCreateDatetime(now);
        data.setUpdateDatetime(now);
        ethAddressDAO.insert(data);
        return code;
    }

    @Override
    public List<EthAddress> queryEthAddressList(EthAddress condition) {
        return ethAddressDAO.selectList(condition);
    }

    @Override
    public EthAddress getMEthAddressToday() {
        EthAddress condition = new EthAddress();
        condition.setType(EEthAddressType.M.getCode());
        condition.setStatus(EEthAddressStatus.NORMAL.getCode());
        List<EthAddress> mList = ethAddressDAO.selectList(condition);
        if (CollectionUtils.isEmpty(mList)) {
            throw new BizException("xn625000", "未找到今日可用的散取地址");
        }
        return mList.get(0);
    }

    @Override
    public EthAddress getWEthAddressToday() {
        EthAddress condition = new EthAddress();
        condition.setType(EEthAddressType.W.getCode());
        condition.setStatus(EEthAddressStatus.NORMAL.getCode());
        List<EthAddress> wList = ethAddressDAO.selectList(condition);
        if (CollectionUtils.isEmpty(wList)) {
            throw new BizException("xn625000", "未找到今日可用的归集地址");
        }
        return wList.get(0);
    }

    @Override
    public EthAddress getEthAddress(String code) {
        EthAddress data = null;
        if (StringUtils.isNotBlank(code)) {
            EthAddress condition = new EthAddress();
            condition.setCode(code);
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

    @Override
    public BigDecimal getEthBalance(String address) {
        try {
            DefaultBlockParameter defaultBlockParameter = DefaultBlockParameterName.LATEST;
            EthGetBalance ethGetBalance = web3j.ethGetBalance(address,
                defaultBlockParameter).send();
            if (ethGetBalance != null) {
                return new BigDecimal(ethGetBalance.getBalance().toString());
            } else {
                throw new BizException("xn625000", "以太坊余额查询失败");
            }
        } catch (Exception e) {
            throw new BizException("xn625000", "以太坊余额查询异常，原因：" + e.getMessage());
        }
    }

}
