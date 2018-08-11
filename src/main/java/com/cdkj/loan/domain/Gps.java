package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* gps
* @author: xieyj 
* @since: 2018-05-26 20:26:21
* @history:
*/
public class Gps extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // gps编号
    private String gpsDevNo;

    // gps类型(1有限0无线)
    private String gpsType;

    // 公司编号
    private String companyCode;

    // 公司申领状态(0 待申领 1 已申领)
    private String companyApplyStatus;

    // 公司申领日期
    private Date companyApplyDatetime;

    // 公司申领单编号
    private String companyApplyCode;

    // 申领人id
    private String applyUser;

    // 申领日期
    private Date applyDatetime;

    // 个人申领状态(0 待申领 1 申领处理中 2 已申领)
    private String applyStatus;

    // 个人申领单号
    private String applyCode;

    // 使用状态(0待使用1使用中2已损坏)
    private String useStatus;

    // 使用日期
    private Date useDatetime;

    // 业务编号
    private String bizCode;

    /*****************/
    // 公司编号
    private String companyName;

    // 申请人姓名
    private String applyUserName;

    public String getCompanyApplyStatus() {
        return companyApplyStatus;
    }

    public void setCompanyApplyStatus(String companyApplyStatus) {
        this.companyApplyStatus = companyApplyStatus;
    }

    public Date getCompanyApplyDatetime() {
        return companyApplyDatetime;
    }

    public void setCompanyApplyDatetime(Date companyApplyDatetime) {
        this.companyApplyDatetime = companyApplyDatetime;
    }

    public String getCompanyApplyCode() {
        return companyApplyCode;
    }

    public void setCompanyApplyCode(String companyApplyCode) {
        this.companyApplyCode = companyApplyCode;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getGpsDevNo() {
        return gpsDevNo;
    }

    public void setGpsDevNo(String gpsDevNo) {
        this.gpsDevNo = gpsDevNo;
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

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getUseDatetime() {
        return useDatetime;
    }

    public void setUseDatetime(Date useDatetime) {
        this.useDatetime = useDatetime;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

}
