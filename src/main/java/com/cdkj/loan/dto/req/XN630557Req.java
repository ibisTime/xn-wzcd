package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 结果处理
 * @author: silver 
 * @since: 2018年6月16日 下午3:09:50 
 * @history:
 */
public class XN630557Req {
    // 编号
    @NotBlank
    private String code;

    // 处理结果
    @NotBlank
    private String dealResult;

    // 出售价格
    private String sellPrice;

    // 保证金
    private String deposit;

    // 费用说明
    private String feeNote;

    // 处理结果附件
    private String dealEnclosure;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealEnclosure() {
        return dealEnclosure;
    }

    public void setDealEnclosure(String dealEnclosure) {
        this.dealEnclosure = dealEnclosure;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getFeeNote() {
        return feeNote;
    }

    public void setFeeNote(String feeNote) {
        this.feeNote = feeNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
