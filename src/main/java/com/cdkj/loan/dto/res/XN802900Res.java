/**
 * @Title XN802900Res.java 
 * @Package com.cdkj.loan.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2018年6月1日 上午4:37:15 
 * @version V1.0   
 */
package com.cdkj.loan.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2018年6月1日 上午4:37:15 
 * @history:
 */
public class XN802900Res {

    // 充值总额
    private Long totalCharge;

    // 提现总额
    private Long totalWithdraw;

    // 消费总额
    private Long totalConsume;

    public Long getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Long totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Long getTotalWithdraw() {
        return totalWithdraw;
    }

    public void setTotalWithdraw(Long totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    public Long getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(Long totalConsume) {
        this.totalConsume = totalConsume;
    }

}
