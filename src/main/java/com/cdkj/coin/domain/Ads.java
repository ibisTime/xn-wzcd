package com.cdkj.coin.domain;

import com.cdkj.coin.dao.base.ABaseDO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Ads extends ABaseDO implements Serializable {
    private String code;

    private String userId;

    private User user;

    private String tradeCurrency;

    private String tradeCoin;

    private String onlyTrust;

    private String tradeType;

    private BigDecimal premiumRate;

    private BigDecimal totalAmount;

    public Ads() {

    }

    ;

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Ads(String code, String userId, String tradeCurrency, String tradeCoin, String onlyTrust, BigDecimal premiumRate, BigDecimal totalAmount, BigDecimal leftAmount, BigDecimal marketPrice, BigDecimal protectPrice, BigDecimal minTrade, BigDecimal maxTrade, String payType, Integer payLimit, String status, Date createDatetime, Date updateDatetime, String leaveMessage) {
        this.code = code;
        this.userId = userId;
        this.tradeCurrency = tradeCurrency;
        this.tradeCoin = tradeCoin;
        this.onlyTrust = onlyTrust;
        this.premiumRate = premiumRate;
        this.totalAmount = totalAmount;
        this.leftAmount = leftAmount;
        this.marketPrice = marketPrice;
        this.protectPrice = protectPrice;
        this.minTrade = minTrade;
        this.maxTrade = maxTrade;
        this.payType = payType;
        this.payLimit = payLimit;
        this.status = status;
        this.createDatetime = createDatetime;
        this.updateDatetime = updateDatetime;
        this.leaveMessage = leaveMessage;
    }


    private BigDecimal leftAmount;

    private BigDecimal marketPrice;

    private BigDecimal protectPrice;

    private BigDecimal minTrade;

    private BigDecimal maxTrade;

    private String payType;

    private Integer payLimit;

    private String status;

    private Date createDatetime;

    private Date updateDatetime;

    private String leaveMessage;

    private List<AdsDisplayTime> displayTime;

    //   以下字段为查询添加  //
    private Integer currentWeek;
    private Double currentTime;

    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(Integer currentWeek) {
        this.currentWeek = currentWeek;
    }

    public Double getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Double currentTime) {
        this.currentTime = currentTime;
    }

    public List<AdsDisplayTime> getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(List<AdsDisplayTime> displayTime) {
        this.displayTime = displayTime;
    }

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency == null ? null : tradeCurrency.trim();
    }

    public String getTradeCoin() {
        return tradeCoin;
    }

    public void setTradeCoin(String tradeCoin) {
        this.tradeCoin = tradeCoin == null ? null : tradeCoin.trim();
    }

    public String getOnlyTrust() {
        return onlyTrust;
    }

    public void setOnlyTrust(String onlyTrust) {
        this.onlyTrust = onlyTrust == null ? null : onlyTrust.trim();
    }

    public BigDecimal getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(BigDecimal premiumRate) {
        this.premiumRate = premiumRate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(BigDecimal leftAmount) {
        this.leftAmount = leftAmount;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getProtectPrice() {
        return protectPrice;
    }

    public void setProtectPrice(BigDecimal protectPrice) {
        this.protectPrice = protectPrice;
    }

    public BigDecimal getMinTrade() {
        return minTrade;
    }

    public void setMinTrade(BigDecimal minTrade) {
        this.minTrade = minTrade;
    }

    public BigDecimal getMaxTrade() {
        return maxTrade;
    }

    public void setMaxTrade(BigDecimal maxTrade) {
        this.maxTrade = maxTrade;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Integer getPayLimit() {
        return payLimit;
    }

    public void setPayLimit(Integer payLimit) {
        this.payLimit = payLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage == null ? null : leaveMessage.trim();
    }
}