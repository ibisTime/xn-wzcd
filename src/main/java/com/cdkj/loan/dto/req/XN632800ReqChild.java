package com.cdkj.loan.dto.req;

public class XN632800ReqChild {

    // 成员姓名
    private String realName;

    // 与本人关系
    private String relation;

    // 工作单位
    private String companyName;

    // 担任职务
    private String post;

    // 联系方式
    private String contact;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
