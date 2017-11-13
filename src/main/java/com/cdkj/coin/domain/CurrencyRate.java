package com.cdkj.coin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CurrencyRate implements Serializable {
    private String currency;

    private String referCurrency;

    private String origin;

    private BigDecimal rate;

    private Date updateDatetime;

    private static final long serialVersionUID = 1L;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getReferCurrency() {
        return referCurrency;
    }

    public void setReferCurrency(String referCurrency) {
        this.referCurrency = referCurrency == null ? null : referCurrency.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}