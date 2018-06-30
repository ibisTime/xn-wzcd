package com.cdkj.loan.dto.req;

/**
 * 发票不匹配申请 返点明细用款用途
 * @author: jiafr 
 * @since: 2018年6月30日 下午4:04:09 
 * @history:
 */
public class XN632230ReqChild {

    // 汽车经销商编号
    private String carDealerCode;

    // 业务公司编号
    private String companyCode;

    // 用款用途
    private String useMoneyPurpose;

    // 返点金额(返点金额或应退按揭款)
    private String repointAmount;

    // 账号编号（公司或车行的收款账号编号）
    private String accountCode;

    // 收款账号（用于客户不垫资，手动输入的应退按揭款的收款账号 ）
    private String mortgageAccountNo;

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

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

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getMortgageAccountNo() {
        return mortgageAccountNo;
    }

    public void setMortgageAccountNo(String mortgageAccountNo) {
        this.mortgageAccountNo = mortgageAccountNo;
    }

}
