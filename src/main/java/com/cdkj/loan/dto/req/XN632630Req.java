package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:49:33 
 * @history:
 */
public class XN632630Req {
    // 违章人编号
    @NotBlank
    private String userId;

    // 车牌号
    @NotBlank
    private String carNo;

    // 违章时间
    @NotBlank
    private String happenDatetime;

    // 违章地点
    @NotBlank
    private String address;

    // 违章行为
    @NotBlank
    private String action;

    // 记分
    @NotBlank
    private String score;

    // 罚款金额
    @NotBlank
    private String punishAmount;

    // 处理情况
    @NotBlank
    private String handleNote;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getHappenDatetime() {
        return happenDatetime;
    }

    public void setHappenDatetime(String happenDatetime) {
        this.happenDatetime = happenDatetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPunishAmount() {
        return punishAmount;
    }

    public void setPunishAmount(String punishAmount) {
        this.punishAmount = punishAmount;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

}
