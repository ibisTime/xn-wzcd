package com.cdkj.coin.enums;

import java.util.HashMap;
import java.util.Map;

import com.cdkj.coin.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:09:32 
 * @history:
 */
public enum EBizType {
    AJ_CHARGE("charge", "ETH充值"), AJ_WITHDRAW("withdraw", "ETH取现"), AJ_BUY(
            "buy", "平台转入"), AJ_SELL("sell", "平台转出"), AJ_TFEE("tfee", "交易手续费"), AJ_WFEE(
            "wfee", "提现手续费"), AJ_INVITE("invite", "邀请好友送"), AJ_HCLB("HL",
            "红冲蓝补"), Transfer_CURRENCY("201", "同币种的划转"), EXCHANGE_CURRENCY(
            "200", "币种兑换"), Transfer_CURRENCY_C2C("206", "C端用户间转账");

    public static EBizType getBizType(String code) {
        Map<String, EBizType> map = getBizTypeMap();
        EBizType result = map.get(code);
        if (result == null) {
            throw new BizException("XN0000", code + "对应的bizType不存在");
        }
        return result;
    }

    public static Map<String, EBizType> getBizTypeMap() {
        Map<String, EBizType> map = new HashMap<String, EBizType>();
        for (EBizType bizType : EBizType.values()) {
            map.put(bizType.getCode(), bizType);
        }
        return map;
    }

    EBizType(String code, String value) {
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
