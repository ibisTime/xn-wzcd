package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 公告或制度人员范围
* @author: silver 
* @since: 2018-06-07 13:13:23
* @history:
*/
public class ScopePeople extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private String id;

    // 类型(所有人员=-1,分公司=1，部门=2,职位=3，具体人=4)
    private String type;

    // 具体类型人员编号
    private String peopleCode;

    // 参考编号
    private String refCode;

    private String peopleName;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPeopleCode(String peopleCode) {
        this.peopleCode = peopleCode;
    }

    public String getPeopleCode() {
        return peopleCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getRefCode() {
        return refCode;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

}
