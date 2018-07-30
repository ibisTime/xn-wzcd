package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代偿审核确认放款
 * @author: jiafr 
 * @since: 2018年7月30日 上午10:24:35 
 * @history:
 */
public class XN632335Req {
    // 编号
    @NotBlank
    private String code;

    // 代偿利率
    @NotBlank
    private String repayRate;

    // 付款日期
    @NotBlank
    private String repayDate;

    // 付款人
    @NotBlank
    private String repayUser;

    // 付款凭证
    @NotBlank
    private String repayBill;

    // 付款说明
    private String repayNote;

    // 更新人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(String repayRate) {
        this.repayRate = repayRate;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayUser() {
        return repayUser;
    }

    public void setRepayUser(String repayUser) {
        this.repayUser = repayUser;
    }

    public String getRepayBill() {
        return repayBill;
    }

    public void setRepayBill(String repayBill) {
        this.repayBill = repayBill;
    }

    public String getRepayNote() {
        return repayNote;
    }

    public void setRepayNote(String repayNote) {
        this.repayNote = repayNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
