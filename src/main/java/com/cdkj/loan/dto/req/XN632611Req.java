package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 审核加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:43:46 
 * @history:
 */
public class XN632611Req {

    @NotBlank
    private String code;

    private String remark;

    @NotBlank
    private String approveResult;

    @NotBlank
    private String updater;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

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

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

}
