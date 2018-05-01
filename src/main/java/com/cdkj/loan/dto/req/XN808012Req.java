/**
 * @Title XN601001Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:08:54 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:08:54 
 * @history:
 */
public class XN808012Req {

    // 产品编号
    @NotBlank
    private String code;

    // 产品小类(必填)
    @NotBlank
    private String type;

    // 产品名称(必填)
    @NotBlank
    private String name;

    // 广告语(必填)
    @NotBlank
    private String slogan;

    // 广告图片(必填)
    @NotBlank
    private String advPic;

    // 销售状态(选填)
    private String saleStatus;

    // pic(必填)
    @NotBlank
    private String pic;

    // 产品详情(必填)
    @NotBlank
    private String description;

    // 市场参考价，原价
    @NotBlank
    private String originalPrice;

    // 现价(人民币)
    @NotBlank
    private String price;

    // 最低购买信用分
    @NotBlank
    private String creditScore;

    // 更新人(必填)
    @NotBlank
    private String updater;

    // 备注(选填)
    private String remark;

    // ***********db properties***********

    // 产品参数列表
    private List<XN808030Req> productSpecsList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
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

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
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

    public List<XN808030Req> getProductSpecsList() {
        return productSpecsList;
    }

    public void setProductSpecsList(List<XN808030Req> productSpecsList) {
        this.productSpecsList = productSpecsList;
    }
}
