package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:35:52 
 * @history:
 */
public class XN632080Req {
    // 编号
    @NotBlank
    private String code;

    // 类型(1 新车 2 二手车)（必填）
    @NotBlank
    private String type;

    // 最低成数（必填）
    @NotBlank
    private String minCs;

    // 最高成数（必填）
    @NotBlank
    private String maxCs;

    // 备注（选填）
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMinCs() {
        return minCs;
    }

    public void setMinCs(String minCs) {
        this.minCs = minCs;
    }

    public String getMaxCs() {
        return maxCs;
    }

    public void setMaxCs(String maxCs) {
        this.maxCs = maxCs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
