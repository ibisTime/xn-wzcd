package com.cdkj.loan.dto.req;

public class XN632707Req extends AListReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 565602656313457896L;

    // gps编号
    private String gpsDevNo;

    // gps类型
    private String gpsType;

    // 公司编号
    private String companyCode;

    // 公司申领编号
    private String companyApplyCode;

    // 公司申领状态
    private String companyApplyStatus;

    // 申请状态
    private String applyStatus;

    // 申请人
    private String applyUser;

    // 使用状态
    private String useStatus;

    // 业务编号
    private String bizCode;

    // 是否回退
    private String isSendBack;

    public String getIsSendBack() {
        return isSendBack;
    }

    public void setIsSendBack(String isSendBack) {
        this.isSendBack = isSendBack;
    }

    public String getCompanyApplyStatus() {
        return companyApplyStatus;
    }

    public void setCompanyApplyStatus(String companyApplyStatus) {
        this.companyApplyStatus = companyApplyStatus;
    }

    public String getCompanyApplyCode() {
        return companyApplyCode;
    }

    public void setCompanyApplyCode(String companyApplyCode) {
        this.companyApplyCode = companyApplyCode;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getGpsDevNo() {
        return gpsDevNo;
    }

    public void setGpsDevNo(String gpsDevNo) {
        this.gpsDevNo = gpsDevNo;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }
}
