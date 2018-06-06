package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 福利发放人员
 * @author: silver 
 * @since: 2018年6月6日 下午8:17:14 
 * @history:
 */
public class WelfareUser extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 福利编号
    private String welfareCode;

    // 用户编号
    private String userId;

    // 备注
    private String remark;

    // 用户名称
    private String userName;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setWelfareCode(String welfareCode) {
        this.welfareCode = welfareCode;
    }

    public String getWelfareCode() {
        return welfareCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
