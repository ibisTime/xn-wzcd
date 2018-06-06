package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 福利发放审核
 * @author: silver 
 * @since: 2018年6月6日 下午7:28:08 
 * @history:
 */
public class XN632661Req {
    // 编号
    @NotBlank
    private String code;

    // 更新人
    @NotBlank
    private String updater;

    // 审核结果(1 通过 2 不通过)
    @NotBlank
    private String approveResult;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

}
