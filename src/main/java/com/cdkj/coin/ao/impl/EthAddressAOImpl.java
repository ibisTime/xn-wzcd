/**
 * @Title EthAddressAOImpl.java 
 * @Package com.cdkj.coin.ao.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年10月27日 下午5:43:34 
 * @version V1.0   
 */
package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.WalletUtils;

import com.cdkj.coin.ao.IEthAddressAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.ICtqBO;
import com.cdkj.coin.bo.IEthAddressBO;
import com.cdkj.coin.bo.IEthCollectionBO;
import com.cdkj.coin.bo.IEthTransactionBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ISmsOutBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.IWithdrawBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.EthAddress;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.enums.ECaptchaType;
import com.cdkj.coin.enums.EEthAddressStatus;
import com.cdkj.coin.enums.EEthAddressType;
import com.cdkj.coin.enums.ESysUser;
import com.cdkj.coin.enums.ESystemCode;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

/** 
 * @author: haiqingzheng 
 * @since: 2017年10月27日 下午5:43:34 
 * @history:
 */
@Service
public class EthAddressAOImpl implements IEthAddressAO {
    private static final Logger logger = LoggerFactory
        .getLogger(EthAddressAOImpl.class);

    @Autowired
    private IEthAddressBO ethAddressBO;

    @Autowired
    private IEthCollectionBO ethCollectionBO;

    @Autowired
    private IWithdrawBO withdrawBO;

    @Autowired
    private IEthTransactionBO ethTransactionBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ICtqBO ctqBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    public void addEthAddress(String address, String label, String userId,
            String smsCaptcha, String isCerti, String tradePwd) {

        // 地址有效性校验
        if (!WalletUtils.isValidAddress(address)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "地址不符合以太坊规则，请仔细核对");
        }

        // 用户ID校验
        User user = userBO.getUser(userId);
        if (user == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "编号为"
                    + userId + "的用户不存在");
        }

        EEthAddressStatus status = EEthAddressStatus.NORMAL;

        // 是否设置为认证账户
        if (EBoolean.YES.getCode().equals(isCerti)) {
            if (StringUtils.isBlank(tradePwd)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资金密码不能为空");
            }
            // 验证资金密码
            userBO.checkTradePwd(userId, tradePwd);
            status = EEthAddressStatus.CERTI;
        }

        // 验证码校验
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha,
            ECaptchaType.ADDRESS_ADD.getCode(), ESystemCode.COIN.getCode(),
            ESystemCode.COIN.getCode());

        ethAddressBO.saveEthAddress(EEthAddressType.Y, userId, address, label,
            null, BigDecimal.ZERO, null, null, status);

    }

    @Override
    public void abandonAddress(String code) {
        EthAddress ethAddress = ethAddressBO.getEthAddress(code);
        if (EEthAddressStatus.INVALID.getCode().equals(ethAddress.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "地址已失效，无需重复弃用");
        }
        ethAddressBO.abandonAddress(ethAddress);
    }

    @Override
    public EEthAddressType getType(String address) {
        EEthAddressType type = EEthAddressType.Y;
        EthAddress condition = new EthAddress();
        condition.setAddress(address);
        List<EthAddress> results = ethAddressBO.queryEthAddressList(condition);
        if (CollectionUtils.isNotEmpty(results)) {
            EthAddress ethAddress = results.get(0);
            type = EEthAddressType.getEthAddressType(ethAddress.getType());
        }
        return type;
    }

    @Override
    public String generateMAddress(Date availableDatetimeStart,
            Date availableDatetimeEnd) {
        if (availableDatetimeEnd.before(availableDatetimeStart)) {
            throw new BizException("625000", "可使用时间范围有误");
        }
        String ethAccountName = OrderNoGenerater.generate("M");
        String address = ethAddressBO.generateAddress(EEthAddressType.M,
            ethAccountName, ESysUser.SYS_USER_ETH.getCode(),
            availableDatetimeStart, availableDatetimeEnd);
        // 通知橙提取
        ctqBO.uploadAddress(address, EEthAddressType.M.getCode());
        return address;
    }

    @Override
    public String importWAddress(String address, Date availableDatetimeStart,
            Date availableDatetimeEnd) {
        return ethAddressBO.saveEthAddress(EEthAddressType.W,
            ESysUser.SYS_USER_ETH.getCode(), address,
            EEthAddressType.W.getValue(), null, BigDecimal.ZERO,
            availableDatetimeStart, availableDatetimeEnd,
            EEthAddressStatus.NORMAL);
    }

    @Override
    @Transactional
    public Paginable<EthAddress> queryEthAddressPage(int start, int limit,
            EthAddress condition) {
        Paginable<EthAddress> results = ethAddressBO.getPaginable(start, limit,
            condition);
        for (EthAddress ethAddress : results.getList()) {
            // 获取以太坊余额
            BigDecimal balance = ethAddressBO.getEthBalance(ethAddress
                .getAddress());
            ethAddress.setBalance(balance);
            // 地址拥有者信息
            ethAddress.setUser(userBO.getUser(ethAddress.getUserId()));
            // 归集地址统计
            if (EEthAddressType.W.getCode().equals(ethAddress.getType())) {
                EthAddress xAddress = ethCollectionBO
                    .getAddressUseInfo(ethAddress.getAddress());
                ethAddress.setUseCount(xAddress.getUseCount());
                ethAddress.setUseAmount(xAddress.getUseAmount());
            }
            // 散取地址统计
            if (EEthAddressType.M.getCode().equals(ethAddress.getType())) {
                EthAddress xAddress = withdrawBO.getAddressUseInfo(ethAddress
                    .getAddress());
                ethAddress.setUseCount(xAddress.getUseCount());
                ethAddress.setUseAmount(xAddress.getUseAmount());
            }
            // 更新以太坊余额
            ethAddressBO.refreshBalance(ethAddress, balance);
        }
        return results;
    }

    @Override
    public EthAddress getEthAddress(String code) {
        return ethAddressBO.getEthAddress(code);
    }

}
