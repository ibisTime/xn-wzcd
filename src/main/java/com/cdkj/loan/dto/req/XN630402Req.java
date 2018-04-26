package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630402Req {

    // 编号（必填）
    @NotBlank(message = "编号不能为空")
    private String code;

    // 名称（必填）
    @NotBlank(message = "名称不能为空")
    private String name;

    // logo（必填）
    @NotBlank(message = "logo不能为空")
    private String logo;

    // 品牌介绍（必填）
    @NotBlank(message = "品牌介绍不能为空")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
