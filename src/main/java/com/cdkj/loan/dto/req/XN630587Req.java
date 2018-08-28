package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 是否经过车辆抵押
 * @author: CYL 
 * @since: 2018年8月28日 下午5:31:08 
 * @history:
 */
public class XN630587Req {
    // 还款业务编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
