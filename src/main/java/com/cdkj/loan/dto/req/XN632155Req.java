package com.cdkj.loan.dto.req;

/**
 * 垫资分页查询
 * @author: jiafr 
 * @since: 2018年5月29日 下午2:16:08 
 * @history:AS
 */
public class XN632155Req {

    // 预算单编号
    private String budgetCode;

    // 垫资单编号
    private String advanceFundCode;

    // 垫资金额（选填）
    private String advanceFundAmount;

    // 是否垫资(选填)
    private String isAdvanceFund;

    // 收款账号编号（选填）
    private String collectBankcardCode;

    // 操作人
    private String operator;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getAdvanceFundCode() {
        return advanceFundCode;
    }

    public void setAdvanceFundCode(String advanceFundCode) {
        this.advanceFundCode = advanceFundCode;
    }

    public String getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public void setAdvanceFundAmount(String advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getCollectBankcardCode() {
        return collectBankcardCode;
    }

    public void setCollectBankcardCode(String collectBankcardCode) {
        this.collectBankcardCode = collectBankcardCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
