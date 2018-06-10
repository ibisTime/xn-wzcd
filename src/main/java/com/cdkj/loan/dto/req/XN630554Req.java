package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 业务团队解除抵押
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:34 
 * @history:
 */
public class XN630554Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 最近修改人
    @NotBlank
    private String operator;

    // 解除抵押时间
    private String releaseDatetime;

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

    public String getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(String releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
    }

}
