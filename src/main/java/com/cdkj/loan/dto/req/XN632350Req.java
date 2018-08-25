package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增公司结清记录
 * @author: CYL 
 * @since: 2018年8月24日 下午5:32:03 
 * @history:
 */
public class XN632350Req {

    // 业务编号
    @NotBlank(message = "业务编号不能为空")
    private String repaybizCode;

    // 更新人(必填)
    @NotBlank(message = "更新人不能为空")
    private String updater;

    // 备注(选填)
    private String remark;

    public String getRepaybizCode() {
        return repaybizCode;
    }

    public void setRepaybizCode(String repaybizCode) {
        this.repaybizCode = repaybizCode;
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
