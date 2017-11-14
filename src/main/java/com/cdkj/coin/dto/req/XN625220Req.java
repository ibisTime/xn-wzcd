package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625220Req {

    @NotBlank
    private String userId;

    //发布类型 0 存草稿，1直接发布
    @NotBlank
    private String publishType;

    // 交易 数字货币类型
    private String tradeCurrency;

    @NotBlank
    private String tradeCoin;

    @NotBlank
    private String onlyTrust;

    //溢价率
    @NotBlank
    @DecimalMin("-0.9999")
    @DecimalMax("0.9999")
    private String premiumRate;

    // 交易总量
    @NotBlank
    private String totalAmount;

    // 保护价格
    @NotBlank
    private String protectPrice;

    //单笔最小
    @NotBlank
    private String minTrade;

    //单笔最大
    @NotBlank
    private String maxTrade;

    //支付类型
    @NotBlank
    private String payType;

    //付款超时时间
    private String payLimit;

    //留言
    @NotBlank
    private String leaveMessage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getTradeCoin() {
        return tradeCoin;
    }

    public void setTradeCoin(String tradeCoin) {
        this.tradeCoin = tradeCoin;
    }

    public String getOnlyTrust() {
        return onlyTrust;
    }

    public void setOnlyTrust(String onlyTrust) {
        this.onlyTrust = onlyTrust;
    }

    public String getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(String premiumRate) {
        this.premiumRate = premiumRate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProtectPrice() {
        return protectPrice;
    }

    public void setProtectPrice(String protectPrice) {
        this.protectPrice = protectPrice;
    }

    public String getMinTrade() {
        return minTrade;
    }

    public void setMinTrade(String minTrade) {
        this.minTrade = minTrade;
    }

    public String getMaxTrade() {
        return maxTrade;
    }

    public void setMaxTrade(String maxTrade) {
        this.maxTrade = maxTrade;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayLimit() {
        return payLimit;
    }

    public void setPayLimit(String payLimit) {
        this.payLimit = payLimit;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }
}
