package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:16:56 
 * @history:
 */
public class XN632290Req {

    @NotBlank
    private String budgetOrderCode;

    @NotBlank
    private String carDealerCode;

    @NotBlank
    private String useMoneyPurpose;

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

}
