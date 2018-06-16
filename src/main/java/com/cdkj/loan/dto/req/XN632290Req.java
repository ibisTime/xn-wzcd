package com.cdkj.loan.dto.req;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:16:56 
 * @history:
 */
public class XN632290Req {

    private String budgetOrderCode;

    private String carDealerCode;

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
