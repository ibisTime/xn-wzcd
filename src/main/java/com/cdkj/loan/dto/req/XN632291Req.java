package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 协议收费
 * @author: jiafr 
 * @since: 2018年6月19日 上午3:29:47 
 * @history:
 */
public class XN632291Req {

    @NotBlank
    private String budgetOrderCode;

    @NotBlank
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
