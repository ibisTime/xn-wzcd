package com.cdkj.loan.dto.req;

/**
 * 列表查询费用预支申请
 * @author: xieyj 
 * @since: 2018年6月6日 下午9:17:55 
 * @history:
 */
public class XN632677Req extends AListReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -2988293364347757686L;

    // 类型
    private String type;

    // 关联资产审批编号
    private String refAssertCode;

    // 关联车贷业务编号
    private String refBudgetOrderCode;

    // 状态
    private String status;

    // 申请人
    private String applyUser;

    // 申请时间起
    private String applyDateStart;

    // 申请时间止
    private String applyDateEnd;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefAssertCode() {
        return refAssertCode;
    }

    public void setRefAssertCode(String refAssertCode) {
        this.refAssertCode = refAssertCode;
    }

    public String getRefBudgetOrderCode() {
        return refBudgetOrderCode;
    }

    public void setRefBudgetOrderCode(String refBudgetOrderCode) {
        this.refBudgetOrderCode = refBudgetOrderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDateStart() {
        return applyDateStart;
    }

    public void setApplyDateStart(String applyDateStart) {
        this.applyDateStart = applyDateStart;
    }

    public String getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(String applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
    }
}
