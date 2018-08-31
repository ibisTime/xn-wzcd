package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 列表查公司结清记录
 * @author: CYL 
 * @since: 2018年8月24日 下午5:32:03 
 * @history:
 */
public class XN632357Req {

    // 业务编号
    @NotBlank(message = "业务编号不能为空")
    private String repaybizCode;

    public String getRepaybizCode() {
        return repaybizCode;
    }

    public void setRepaybizCode(String repaybizCode) {
        this.repaybizCode = repaybizCode;
    }

}
