package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午9:57:07 
 * @history:
 */
public class XN632741Req {
    // 编号
    @NotBlank
    private String code;

    // 名称
    @NotBlank
    private String name;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
