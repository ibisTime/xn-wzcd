package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询垫资单
 * @author: jiafr 
 * @since: 2018年6月17日 下午9:10:13 
 * @history:
 */
public class XN632186Req {
    // 垫资单编号（必填）
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
