package com.cdkj.loan.dto.req;

/**
 * 列表查询省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:34:07 
 * @history:
 */
public class XN632027Req {
    // 省份序号
    private String id;

    // 省份编号
    private String provinceNo;

    // 省份名称
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
