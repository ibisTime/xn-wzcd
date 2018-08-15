package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 工作经历
* @author: xieyj 
* @since: 2018-06-05 00:06:37
* @history:
*/
public class WorkExperience extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 父级编号
    private String parentCode;

    // 起始时间
    private Date startDatetime;

    // 截止时间
    private Date endDatetime;

    // 工作单位
    private String companyName;

    // 职位
    private String position;

    // 离职原因
    private String leaveReason;

    // 证明人
    private String prover;

    // 证明人联系电话
    private String proverMobile;

    /*---------辅助字段----------*/

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setProver(String prover) {
        this.prover = prover;
    }

    public String getProver() {
        return prover;
    }

    public void setProverMobile(String proverMobile) {
        this.proverMobile = proverMobile;
    }

    public String getProverMobile() {
        return proverMobile;
    }

}
