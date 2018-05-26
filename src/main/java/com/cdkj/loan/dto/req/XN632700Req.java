package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632700Req {
    // gps编号
    @NotBlank
    private String gpsNo;

    // gps类型
    @NotBlank
    private String gpsType;

    public String getGpsNo() {
        return gpsNo;
    }

    public void setGpsNo(String gpsNo) {
        this.gpsNo = gpsNo;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }
}
