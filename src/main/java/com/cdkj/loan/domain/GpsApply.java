package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* gps申领
* @author: xieyj 
* @since: 2018-05-30 22:16:52
* @history:
*/
public class GpsApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1 公司 2 个人)
    private String type;

    // 公司编号
    private String companyCode;

    // 申请人
    private String applyUser;

    // 申请日期
    private Date applyDatetime;

    // 申请原因
    private String applyReason;

    // 申请个数
    private Integer applyCount;

    // 发货日期
    private Date sendDatetime;

    // 收货日期
    private Date receiveDatetime;

    // 状态(0 待审核 1 审核通过,待发货 2 审核不通过 3 已发货,待收货 4 已收货)
    private String status;

    // 备注
    private String remark;

    // **************db propreties**************
    // 申请人名称
    private String applyUserName;

    // 公司名称
    private String companyName;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setReceiveDatetime(Date receiveDatetime) {
        this.receiveDatetime = receiveDatetime;
    }

    public Date getReceiveDatetime() {
        return receiveDatetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
