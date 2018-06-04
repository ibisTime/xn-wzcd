package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 社会关系
 * @author: jiafr 
 * @since: 2018年6月4日 下午10:41:02 
 * @history:
 */
public class SocialRelation extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 人事档案编号
    private String archiveCode;

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setArchiveCode(String archiveCode) {
        this.archiveCode = archiveCode;
    }

    public String getArchiveCode() {
        return archiveCode;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

}
