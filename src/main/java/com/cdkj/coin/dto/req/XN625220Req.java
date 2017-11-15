package com.cdkj.coin.dto.req;

import com.cdkj.coin.domain.AdsDisplayTime;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625220Req {

    @NotBlank
    private String userId;

    //发布类型 0 存草稿，1直接发布
    @NotBlank
    private String publishType;

    // 交易
    @NotBlank
    private String tradeCurrency;

    //数字货币
    @NotBlank
    private String tradeCoin;

    @NotBlank
    private String onlyTrust;

    //溢价率
    @NotNull
    @DecimalMin("-0.9999")
    @DecimalMax("0.9999")
    private BigDecimal premiumRate;

    // 交易总量
    @NotNull
    private BigDecimal totalAmount;

    // 保护价格
    @NotNull
    private BigDecimal protectPrice;

    //单笔最小
    @NotNull
    private BigDecimal minTrade;

    //单笔最大
    @NotNull
    private BigDecimal maxTrade;

    //支付类型
    @NotBlank
    private String payType;

    //付款超时时间
    private String payLimit;

    //留言
    @NotBlank
    private String leaveMessage;

    List<AdsDisplayTime> displayTime;


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

    public List<AdsDisplayTime> getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(List<AdsDisplayTime> displayTime) {
        this.displayTime = displayTime;
    }
}
