package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN808000Req {

    // 父编号(必填)
    @NotBlank
    private String parentCode;

    // 分类名称(必填)
    @NotBlank
    private String name;

    // 分类图片(选填)
    private String pic;

    // 顺序(必填)
    @NotBlank
    private String orderNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}
