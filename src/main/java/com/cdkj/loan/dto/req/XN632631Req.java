package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 违章处理审核
 * @author: silver 
 * @since: 2018年6月6日 下午5:00:05 
 * @history:
 */
public class XN632631Req {
    // 编号
    @NotBlank
    private String code;

    // 更新人
    @NotBlank
    private String updater;

    // 审核结果(1 通过 2 不通过)
    @NotBlank
    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
