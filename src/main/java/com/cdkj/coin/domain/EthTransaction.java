package com.cdkj.coin.domain;

import com.cdkj.coin.dao.base.ABaseDO;

/**
* 以太坊交易
* @author: haiqingzheng
* @since: 2017年10月29日 19:13:13
* @history:
*/
public class EthTransaction extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 交易hash
    private String hash;

    // 第几个交易
    private String nonce;

    // 区块hash
    private String blockHash;

    // 区块编号
    private String blockNumber;

    // transactionIndex
    private String transactionIndex;

    // 发送地址
    private String from;

    // 接受地址
    private String to;

    // 数量
    private String value;

    // gas价格
    private String gasPrice;

    // gas价格
    private String gasUsed;

    // 消耗gas
    private String gas;

    // input
    private String input;

    // 创建时间
    private String creates;

    // publicKey
    private String publicKey;

    // raw
    private String raw;

    // r
    private String r;

    // s
    private String s;

    private String refNo;

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNonce() {
        return nonce;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGas() {
        return gas;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    public String getCreates() {
        return creates;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getR() {
        return r;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

}
