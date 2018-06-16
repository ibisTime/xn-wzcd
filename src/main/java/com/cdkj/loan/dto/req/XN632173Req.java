package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 总公司制单
 * @author: jiafr 
 * @since: 2018年6月16日 上午11:17:28 
 * @history:
 */
public class XN632173Req {

    // 垫资单编号
    @NotBlank
    private String code;

    // 制单意见说明
    private String makeBillNote;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
