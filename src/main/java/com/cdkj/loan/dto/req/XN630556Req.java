package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入收车结果
 * @author: silver 
 * @since: 2018年6月16日 下午3:07:44 
 * @history:
 */
public class XN630556Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 收车地点
    @NotBlank
    private String takeCarAddress;

    // 收车时间
    @NotBlank
    private String takeDatetime;

    // 收车人员
    @NotBlank
    private String takeName;

    // 收车停放位置
    @NotBlank
    private String takeLocation;

    // 收车说明
    private String takeNote;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    public String getTakeLocation() {
        return takeLocation;
    }

    public void setTakeLocation(String takeLocation) {
        this.takeLocation = takeLocation;
    }

    public String getTakeNote() {
        return takeNote;
    }

    public void setTakeNote(String takeNote) {
        this.takeNote = takeNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
