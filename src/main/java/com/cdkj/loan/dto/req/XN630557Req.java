package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630557Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String operator;// 操作人

    @NotBlank
    private String takeCarAddress;// 收车地点

    @NotBlank
    private String takeDatetime;// 拖车时间

    @NotBlank
    private String takeLocation;// 拖车停放位置

    @NotBlank
    private String takeName;// 拖车人员

    private String takeNote;// 拖车说明

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTakeCarAddress() {
        return takeCarAddress;
    }

    public void setTakeCarAddress(String takeCarAddress) {
        this.takeCarAddress = takeCarAddress;
    }

    public String getTakeDatetime() {
        return takeDatetime;
    }

    public void setTakeDatetime(String takeDatetime) {
        this.takeDatetime = takeDatetime;
    }

    public String getTakeLocation() {
        return takeLocation;
    }

    public void setTakeLocation(String takeLocation) {
        this.takeLocation = takeLocation;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    public String getTakeNote() {
        return takeNote;
    }

    public void setTakeNote(String takeNote) {
        this.takeNote = takeNote;
    }

}
