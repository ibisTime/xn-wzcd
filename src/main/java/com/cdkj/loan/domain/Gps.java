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

    // gps类型
    private String gpsType;

    // 公司编号
    private String companyCode;

    // 申请人
    private String applyUser;

    // 申请状态
    private String applyStatus;

    // 申请日期
    private Date applyDatetime;

    // 使用状态
    private String useStatus;

    // 使用日期
    private Date useDatetime;

    // 业务编号
    private String bizCode;

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
}
