package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632651Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String approveResult;// 审核结果

    @NotBlank
    private String updater;// 更新人

    private String remark;// 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
