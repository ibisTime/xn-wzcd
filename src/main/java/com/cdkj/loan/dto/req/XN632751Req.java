package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改品名
 * @author: silver 
 * @since: 2018年6月4日 下午11:09:31 
 * @history:
 */
public class XN632751Req {
    // 编号
    @NotBlank
    private String code;

    // 类别编号
    @NotBlank
    private String categoryCode;

    // 品名
    @NotBlank
    private String name;

    // 规格型号
    @NotBlank
    private String model;

    // 单位
    @NotBlank
    private String unit;

    // 备注
    private String remark;

    // 更新人
    private String updater;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

}
