package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630568Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 判决日期
    @NotBlank
    private String judgeDatetime;

    // 判决结果
    @NotBlank
    private String judgeResult;

    // 判决附件
    @NotBlank
    private String judgePdf;

    // 判决书送达时间
    @NotBlank
    private String judgePdfDeliveryTime;

    // 生效时间
    @NotBlank
    private String effectiveTime;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getJudgeDatetime() {
        return judgeDatetime;
    }

    public void setJudgeDatetime(String judgeDatetime) {
        this.judgeDatetime = judgeDatetime;
    }

    public String getJudgeResult() {
        return judgeResult;
    }

    public void setJudgeResult(String judgeResult) {
        this.judgeResult = judgeResult;
    }

    public String getJudgePdf() {
        return judgePdf;
    }

    public void setJudgePdf(String judgePdf) {
        this.judgePdf = judgePdf;
    }

    public String getJudgePdfDeliveryTime() {
        return judgePdfDeliveryTime;
    }

    public void setJudgePdfDeliveryTime(String judgePdfDeliveryTime) {
        this.judgePdfDeliveryTime = judgePdfDeliveryTime;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

}
