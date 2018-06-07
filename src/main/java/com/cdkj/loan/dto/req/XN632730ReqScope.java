package com.cdkj.loan.dto.req;

/**
 * 制度范围
 * @author: silver 
 * @since: 2018年6月7日 下午2:34:02 
 * @history:
 */
public class XN632730ReqScope {
    // 范围类型(所有人员=-1,分公司=1，部门=2,职位=3，具体人=4)
    private String scopeType;

    // 具体类型人员编号
    private String peopleCode;

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public String getPeopleCode() {
        return peopleCode;
    }

    public void setPeopleCode(String peopleCode) {
        this.peopleCode = peopleCode;
    }

}
