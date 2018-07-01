package com.cdkj.loan.dto.req;

/**
 * 应退按揭款（不垫资） 和 协议外返点
 * @author: jiafr 
 * @since: 2018年7月1日 下午8:53:58 
 * @history:
 */
public class XN632120ReqRepointDetail {

    // 用款用途（1应退按揭款（不垫资） 3协议外返点
    private String useMoneyPurpose;

    // 金额(返点金额或应退按揭款)
    private String repointAmount;

    // 单位名称
    private String carDealerName;

    // 账号
    private String accountNO;

    // 开户行
    private String openBankName;

    // 户名
    private String accountName;

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public String getRepointAmount() {
        return repointAmount;
    }

    public void setRepointAmount(String repointAmount) {
        this.repointAmount = repointAmount;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
