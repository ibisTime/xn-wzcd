package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 宝付代扣记录
* @author: haiqingzheng
* @since: 2017年09月22日 10:50:47
* @history:
*/
public class BaofooWithhold extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 商户订单号
    private String transId;

    // 银行编码
    private String bankCode;

    // 银行卡号
    private String bankcardNumber;

    // 身份证号
    private String idNo;

    // 真实姓名
    private String realName;

    // 手机号
    private String mobile;

    // 代扣金额
    private Long transAmount;

    // 关联订单号
    private String refNo;

    // 应答码
    private String respCode;

    // 应答信息
    private String respMsg;

    // 商户号
    private String memberId;

    // 终端号
    private String terminalId;

    // 交易类型
    private String txnType;

    // 交易子类
    private String txnSubType;

    // 接入类型
    private String bizType;

    // 订单发送时间
    private Date tradeDate;

    // 宝付交易号
    private String transNo;

    // 成功金额
    private Long succAmt;

    // 商户流水号
    private String transSerialNo;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Long transAmount) {
        this.transAmount = transAmount;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public Long getSuccAmt() {
        return succAmt;
    }

    public void setSuccAmt(Long succAmt) {
        this.succAmt = succAmt;
    }

    public String getTransSerialNo() {
        return transSerialNo;
    }

    public void setTransSerialNo(String transSerialNo) {
        this.transSerialNo = transSerialNo;
    }

}
