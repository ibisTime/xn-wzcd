package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630100Req {

    @NotBlank
    private String name;// 部门名称

    private String leadUserId;// 负责人编号

    @NotBlank
    private String parentCode;// 上级部门编号

    @NotBlank
    private String type;// 类型

    private String provinceNo;// 省份编号

    private String cityNo;// 市编号

    private String areaNo;// 区编号

    @NotBlank
    private String orderNo;// 序号

    @NotBlank
    private String updater;// 更新人

    private String remark;// 备注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getLeadUserId() {
        return leadUserId;
    }

    public void setLeadUserId(String leadUserId) {
        this.leadUserId = leadUserId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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
