package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:41:26 
 * @history:
 */
public class XN805162Req {
    // 收件编号（必填）
    @NotBlank
    private String code;

    // 收件人名称（必填）
    @NotBlank
    private String addressee;

    // 手机号（必填）
    @NotBlank
    private String mobile;

    // 省份（必填）
    @NotBlank
    private String province;

    // 城市（必填）
    @NotBlank
    private String city;

    // 区（必填）
    @NotBlank
    private String area;

    // 具体地址（必填）
    @NotBlank
    private String detail;

    // 是否默认地址（选填）
    private String isDefault;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
