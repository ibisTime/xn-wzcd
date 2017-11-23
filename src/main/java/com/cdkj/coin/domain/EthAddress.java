package com.cdkj.coin.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.cdkj.coin.dao.base.ABaseDO;

/**
* 以太坊地址
* @author: haiqingzheng
* @since: 2017年10月23日 21:53:23
* @history:
*/
public class EthAddress extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // ID主键
    private String code;

    // 地址类型
    private String type;

    // 以太坊地址
    private String address;

    // 标签
    private String label;

    // 密码
    private String password;

    // 用户编号
    private String userId;

    // 初始金额
    private transient BigDecimal initialBalance;

    private String initialBalanceString;

    // 以太坊真实余额
    private transient BigDecimal balance;

    private String balanceString;

    // 可用时间起
    private Date availableDatetimeStart;

    // 可用时间止
    private Date availableDatetimeEnd;

    // 状态
    private String status;

    // 创建时间
    private Date createDatetime;

    // 弃用时间
    private Date abandonDatetime;

    // 更新时间
    private Date updateDatetime;

    // 所属用户信息
    private User user;

    private Date today;

    private Long useCount;

    private transient BigDecimal useAmount;

    private String useAmountString;

    public Long getUseCount() {
        return useCount;
    }

    public void setUseCount(Long useCount) {
        this.useCount = useCount;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
        this.balanceString = balance.toString();
    }

    public Date getAvailableDatetimeStart() {
        return availableDatetimeStart;
    }

    public void setAvailableDatetimeStart(Date availableDatetimeStart) {
        this.availableDatetimeStart = availableDatetimeStart;
    }

    public Date getAvailableDatetimeEnd() {
        return availableDatetimeEnd;
    }

    public void setAvailableDatetimeEnd(Date availableDatetimeEnd) {
        this.availableDatetimeEnd = availableDatetimeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getAbandonDatetime() {
        return abandonDatetime;
    }

    public void setAbandonDatetime(Date abandonDatetime) {
        this.abandonDatetime = abandonDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getBalanceString() {
        return balanceString;
    }

    public void setBalanceString(String balanceString) {
        this.balanceString = balanceString;
    }

    public BigDecimal getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(BigDecimal useAmount) {
        this.useAmount = useAmount;
        this.useAmountString = useAmount.toString();
    }

    public String getUseAmountString() {
        return useAmountString;
    }

    public void setUseAmountString(String useAmountString) {
        this.useAmountString = useAmountString;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
        this.initialBalanceString = initialBalance.toString();
    }

    public String getInitialBalanceString() {
        return initialBalanceString;
    }

    public void setInitialBalanceString(String initialBalanceString) {
        this.initialBalanceString = initialBalanceString;
    }

}
