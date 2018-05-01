/**
 * @Title Product.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午8:01:28 
 * @version V1.0   
 */
package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午8:01:28 
 * @history:
 */
public class Product extends ABaseDO {

    private static final long serialVersionUID = 8925323602686009210L;

    // 产品编号
    private String code;

    // 产品大类
    private String category;

    // 产品小类
    private String type;

    // 产品名称
    private String name;

    // 广告语
    private String slogan;

    // 广告图片
    private String advPic;

    // 销售状态
    private String saleStatus;

    // pic
    private String pic;

    // 产品详情
    private String description;

    // 市场参考价，原价
    private Long originalPrice;

    // 现价(人民币)
    private Long price;

    // 最低购买信用分
    private Long creditScore;

    // 位置
    private String location;

    // 相对位置编号
    private Integer orderNo;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 已购买人数（确认收货之后）
    private Integer boughtCount;

    // ******************db properties ********************

    // 产品参数
    private List<ProductSpecs> productSpecsList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Long creditScore) {
        this.creditScore = creditScore;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(Integer boughtCount) {
        this.boughtCount = boughtCount;
    }

    public List<ProductSpecs> getProductSpecsList() {
        return productSpecsList;
    }

    public void setProductSpecsList(List<ProductSpecs> productSpecsList) {
        this.productSpecsList = productSpecsList;
    }

}
