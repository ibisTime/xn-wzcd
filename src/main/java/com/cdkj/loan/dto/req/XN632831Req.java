package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:50:59 
 * @history:
 */
public class XN632831Req {

    // 合同表编号
    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
