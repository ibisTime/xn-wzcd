package com.cdkj.loan.dto.req;

/**
 * 修改离职档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:49:37 
 * @history:
 */
public class XN632812Req {

    private String code;

    private String realName;

    private String leaveDatetime;

    private String heirPeople;

    private String leaveReason;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLeaveDatetime() {
        return leaveDatetime;
    }

    public void setLeaveDatetime(String leaveDatetime) {
        this.leaveDatetime = leaveDatetime;
    }

    public String getHeirPeople() {
        return heirPeople;
    }

    public void setHeirPeople(String heirPeople) {
        this.heirPeople = heirPeople;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
