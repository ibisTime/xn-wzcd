package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630430Req {

    @NotBlank(message = "申请人编号不能为空")
    private String userId; // 申请人编号

    @NotBlank(message = "申请人手机号不能为空")
    private String userMobile; // 申请人手机号

    @NotBlank(message = "品牌编号不能为空")
    private String brandCode; // 品牌编号

    @NotBlank(message = "品牌名称不能为空")
    private String brandName; // 品牌名称

    @NotBlank(message = "车系编号不能为空")
    private String seriesCode; // 车系编号

    @NotBlank(message = "车系名称不能为空")
    private String seriesName; // 车系名称

    @NotBlank(message = "车型编号不能为空")
    private String carCode; // 车型编号

    @NotBlank(message = "车型名称不能为空")
    private String carName; // 车型名称

    @NotBlank(message = "车辆总价不能为空")
    private String price; // 车辆总价

    @NotBlank(message = "首付比例不能为空")
    private String sfRate; // 首付比例

    @NotBlank(message = "首付金额不能为空")
    private String sfAmount; // 首付金额

    @NotBlank(message = "分期期数不能为空")
    private String periods; // 分期期数

    @NotBlank(message = "申请时间不能为空")
    private String createDatetime; // 申请时间

    @NotBlank(message = "计算器信息不能为空")
    private String saleDesc; // 计算器信息

    private String remark; // 备注

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSfRate() {
        return sfRate;
    }

    public void setSfRate(String sfRate) {
        this.sfRate = sfRate;
    }

    public String getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(String sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getSaleDesc() {
        return saleDesc;
    }

    public void setSaleDesc(String saleDesc) {
        this.saleDesc = saleDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
