package com.cdkj.loan.dto.req;

/**
 * 手续费分页查询
 * @author: xieyj 
 * @since: 2018年5月30日 下午7:24:06 
 * @history:
 */
public class XN632165Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号
    private String userId;

    // 是否已结清(0 待结清 1 已结清)
    private String isSettled;

    // 准入单编号
    private String budgetOrder;

    // 更新时间
    private String updateDatetime;

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(String isSettled) {
        this.isSettled = isSettled;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }
}
