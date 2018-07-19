package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 车辆抵押合同打印
 * @author: CYL 
 * @since: 2018年6月30日 下午1:04:40 
 * @history:
 */
public class XN632192Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 车架号码
    private String frameNo;

    // 发动机号码
    private String engineNo;

    // 抵押套打模板
    @NotBlank
    private String pledgePrintTemplateId;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getPledgePrintTemplateId() {
        return pledgePrintTemplateId;
    }

    public void setPledgePrintTemplateId(String pledgePrintTemplateId) {
        this.pledgePrintTemplateId = pledgePrintTemplateId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
