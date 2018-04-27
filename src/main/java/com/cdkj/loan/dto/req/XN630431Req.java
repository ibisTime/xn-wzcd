package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630431Req {

    @NotBlank(message = "编号不能为空")
    private String code; // 编号

    @NotBlank(message = "处理人不能为空")
    private String handler; // 处理人

    private String remark; // 备注

    @NotBlank(message = "处理结果不能为空")
    private String result; // 处理结果（1通过，0不通过）

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
