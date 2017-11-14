package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625226Req {

    @NotBlank
    private String adsCode;

    @NotBlank
    private String tradeType;

    public String getAdsCode() {
        return adsCode;
    }

    public void setAdsCode(String adsCode) {
        this.adsCode = adsCode;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
}
