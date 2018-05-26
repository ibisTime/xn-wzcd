package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

public class InsuranceCompany extends ABaseDO {

    private String code;// 编号

    private String name;// 名称

    private String contact;// 联系人

    private String mobile;// 联系电话

    private String remark;// 备注

    /*--------辅助字段-----------*/

    private String keyword;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
