package com.cdkj.loan.dto.req;

/**
 * 预算单-gps安装列表
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632126ReqGps {

    // gps设备号
    private String gpsDevNo;

    // gps安装位置
    private String azLocation;

    // gps安装日期
    private String azDatetime;

    // gps 安装用户
    private String azUser;

    // 备注
    private String remark;

    public String getGpsDevNo() {
        return gpsDevNo;
    }

    public void setGpsDevNo(String gpsDevNo) {
        this.gpsDevNo = gpsDevNo;
    }

    public String getAzLocation() {
        return azLocation;
    }

    public void setAzLocation(String azLocation) {
        this.azLocation = azLocation;
    }

    public String getAzDatetime() {
        return azDatetime;
    }

    public void setAzDatetime(String azDatetime) {
        this.azDatetime = azDatetime;
    }

    public String getAzUser() {
        return azUser;
    }

    public void setAzUser(String azUser) {
        this.azUser = azUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
