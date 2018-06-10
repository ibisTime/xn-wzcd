package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 驻行人员审核
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:34 
 * @history:
 */
public class XN630551Req {
    // 审核结果(必填)1=通过 0=不通过
    @NotBlank
    private String approveResult;

    // 还款业务编号
    @NotBlank
    private String code;

    // 最近修改人
    @NotBlank
    private String operator;

    // 备注
    private String remark;

    // 结清时间
    private String settleDatetime;

    // 结清证明
    private String settlePdf;

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(String settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public String getSettlePdf() {
        return settlePdf;
    }

    public void setSettlePdf(String settlePdf) {
        this.settlePdf = settlePdf;
    }

}
