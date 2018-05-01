/**
 * @Title Category.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月16日 上午11:11:51 
 * @version V1.0   
 */
package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月16日 上午11:11:51 
 * @history:
 */
public class Category extends ABaseDO {

    private static final long serialVersionUID = 682677933434404190L;

    // 编号
    private String code;

    // 父编号
    private String parentCode;

    // 分类名称
    private String name;

    // 分类图片
    private String pic;

    // 顺序
    private Integer orderNo;

    // 状态
    private String status;

    // ***************db properties
    // 父编号名称
    private String parentName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
