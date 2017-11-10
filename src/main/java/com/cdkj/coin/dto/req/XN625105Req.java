/**
 * @Title XN625100Req.java 
 * @Package com.cdkj.coin.dto.req 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月9日 下午7:02:19 
 * @version V1.0   
 */
package com.cdkj.coin.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2017年11月9日 下午7:02:19 
 * @history:
 */
public class XN625105Req extends APageReq {

    // 被归集地址
    private String fromAddress;

    // 归集地址
    private String toAddress;

    // 交易hash
    private String txHash;

    // 状态
    private String status;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
