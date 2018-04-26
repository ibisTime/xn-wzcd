package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 品牌上架
 * @author: CYL 
 * @since: 2018年4月23日 上午9:50:53 
 * @history:
 */

public class XN630403Req {

    // 编号（必填）
    @NotBlank(message = "编号不能为空")
    private String code;

    // 最新修改人（必填）
    @NotBlank(message = "最新修改人不能为空")
    private String updater;

    // 备注（选填）
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
