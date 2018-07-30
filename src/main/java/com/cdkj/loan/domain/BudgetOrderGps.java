package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* GPS安装
* @author: CYL
* @since: 2018-05-30 17:38:43
* @history:
*/
public class BudgetOrderGps extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // gps设备号
    private String gpsDevNo;

    // gps类型(1有限0无线)
    private String gpsType;

    // 安装位置
    private String azLocation;

    // 安装时间
    private Date azDatetime;

    // 安装人员
    private String azUser;

    // 状态(1 使用中 0 已作废)
    private String status;

    // 备注
    private String remark;

    // 预算单编号
    private String budgetOrder;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setGpsDevNo(String gpsDevNo) {
        this.gpsDevNo = gpsDevNo;
    }

    public String getGpsDevNo() {
        return gpsDevNo;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setAzLocation(String azLocation) {
        this.azLocation = azLocation;
    }

    public String getAzLocation() {
        return azLocation;
    }

    public void setAzDatetime(Date azDatetime) {
        this.azDatetime = azDatetime;
    }

    public Date getAzDatetime() {
        return azDatetime;
    }

    public void setAzUser(String azUser) {
        this.azUser = azUser;
    }

    public String getAzUser() {
        return azUser;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

}
