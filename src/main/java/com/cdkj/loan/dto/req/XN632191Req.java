package com.cdkj.loan.dto.req;

/**
 * 确认抵押完成
 * @author: silver 
 * @since: 2018年6月13日 下午2:48:35 
 * @history:
 */
public class XN632191Req {

    // 预算单编号
    private String code;

    // 操作人
    private String operator;

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

}
