package com.cdkj.coin.enums;

import java.util.HashMap;
import java.util.Map;

import com.cdkj.coin.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:09:32 
 * @history:
 */
public enum EJourBizType {
    AJ_CHARGE("charge", "ETH充值"), AJ_COLLECTION("collection", "归集"), AJ_WITHDRAW(
            "withdraw", "ETH取现"), AJ_BUY("buy", "平台转入"), AJ_SELL("sell", "平台转出"), AJ_TRADEFEE(
            "tradefee", "交易手续费"), AJ_WITHDRAWFEE("withdrawfee", "提现手续费"), AJ_WFEE(
            "mfee", "提现矿工费"), AJ_MFEE("wfee", "归集矿工费"), AJ_INVITE("invite",
            "邀请好友送"), AJ_HCLB("hl", "红冲蓝补"), Transfer_CURRENCY_C2C("transfer",
            "C端用户间转账");

    public static EJourBizType getBizType(String code) {
        Map<String, EJourBizType> map = getBizTypeMap();
        EJourBizType result = map.get(code);
        if (result == null) {
            throw new BizException("XN0000", code + "对应的jourBizType不存在");
        }
        return result;
    }

    public static Map<String, EJourBizType> getBizTypeMap() {
        Map<String, EJourBizType> map = new HashMap<String, EJourBizType>();
        for (EJourBizType bizType : EJourBizType.values()) {
            map.put(bizType.getCode(), bizType);
        }
        return map;
    }

    EJourBizType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
