package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 考核项目
* @author: xieyj 
* @since: 2018-06-05 10:49:07
* @history:
*/
public class CheckProject extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 项目名称
    private String name;

    // 考核指标
    private String checkResult;

    // 考核人
    private String checkUser;

    // 备注
    private String remark;

    // 应聘编号
    private String employApplyCode;

    public String getEmployApplyCode() {
        return employApplyCode;
    }

    public void setEmployApplyCode(String employApplyCode) {
        this.employApplyCode = employApplyCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
