package com.cdkj.loan.dto.req;

/**
 * 分页查询返点明细
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:34:04 
 * @history:
 */
public class XN632295Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 用款用途 (1应退按揭款2协议内应退返点3手动添加返点)
    private String useMoneyPurpose;

    // 预算单编号
    private String budgetOrder;

    // 汽车经销商编号
    private String carDealerCode;

    public String getUseMoneyPurpose() {
        return useMoneyPurpose;
    }

    public void setUseMoneyPurpose(String useMoneyPurpose) {
        this.useMoneyPurpose = useMoneyPurpose;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

}
