/**
 * @Title XN802182Res.java 
 * @Package com.std.account.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月26日 下午4:46:41 
 * @version V1.0   
 */
package com.cdkj.loan.dto.res;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:19:59 
 * @history:
 */
public class XN632290Res {

    // 协议id
    private String id;

    // 用款用途
    private String useMoneyPurpose;

    // 返点金额(返点金额或应退按揭款)
    private Long repointAmount;

    // 账号编号（公司或车行的收款账号编号）
    private String accountCode;

    // 公司名称
    private String companyName;

    // 账号
    private String bankcardNumber;

    // 开户支行
    private String subbranch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public Long getRepointAmount() {
        return repointAmount;
    }

    public void setRepointAmount(Long repointAmount) {
        this.repointAmount = repointAmount;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

}
