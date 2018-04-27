package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630420Req {

    @NotBlank(message = "名称不能为空")
    private String name; // 名称

    @NotBlank(message = "车系名称不能为空")
    private String seriesCode; // 车系名称

    @NotBlank(message = "车系名称不能为空")
    private String seriesName; // 车系名称

    @NotBlank(message = "品牌编号不能为空")
    private String brandCode; // 品牌编号

    @NotBlank(message = "品牌名称不能为空")
    private String brandName; // 品牌名称

    @NotBlank(message = "原价不能为空")
    private String originalPrice; // 原价

    @NotBlank(message = "参考价不能为空")
    private String salePrice; // 参考价

    @NotBlank(message = "首付金额不能为空")
    private String sfAmount; // 首付金额

    @NotBlank(message = "广告语不能为空")
    private String slogan; // 广告语

    @NotBlank(message = "广告图不能为空")
    private String advPic; // 广告图

    @NotBlank(message = "缩略图不能为空")
    private String pic; // 缩略图

    @NotBlank(message = "图文描述不能为空")
    private String description; // 图文描述

    @NotBlank(message = "最新修改人不能为空")
    private String updater; // 最新修改人

    private String remark; // 备注

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(String sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

}
