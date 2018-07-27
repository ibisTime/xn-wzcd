package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 汽车经销商协议上架
 * @author: jiafr 
 * @since: 2018年7月26日 下午9:43:42 
 * @history:
 */
public class XN632064Req {

    @NotBlank
    private String code;// 准入单编号

    private String makeCardRemark;// 制卡备注

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMakeCardRemark() {
        return makeCardRemark;
    }

    public void setMakeCardRemark(String makeCardRemark) {
        this.makeCardRemark = makeCardRemark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
