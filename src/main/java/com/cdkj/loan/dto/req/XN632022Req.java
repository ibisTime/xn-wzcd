package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:34:07 
 * @history:
 */
public class XN632022Req {
    // 序号
    @NotBlank
    private String id;

    // 省份编号
    @NotBlank
    private String provinceNo;

    // 省份名称
    @NotBlank
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
