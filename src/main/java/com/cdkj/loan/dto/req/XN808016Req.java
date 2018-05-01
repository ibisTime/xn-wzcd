package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @since: 2016年5月17日 上午11:18:56 
 * @history:
 */
public class XN808016Req {
    // 产品编号(必填)
    @NotBlank
    private String code;

    // 更新人(必填)
    @NotBlank
    private String updater;

    // 备注(选填)
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

}
