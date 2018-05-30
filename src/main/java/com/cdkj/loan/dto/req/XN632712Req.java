package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * GPS申领审核不通过
 * @author: silver 
 * @since: 2018年5月31日 上午12:33:49 
 * @history:
 */
public class XN632712Req {
    // 编号
    @NotBlank
    private String code;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
