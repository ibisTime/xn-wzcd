package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:31:33 
 * @history:
 */
public class CarBreak extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 违章人编号
    private String userId;

    // 车牌号
    private String carNo;

    // 违章时间
    private Date happenDatetime;

    // 违章地点
    private String address;

    // 违章行为
    private String action;

    // 记分
    private Integer score;

    // 罚款金额
    private Long punishAmount;

    // 处理情况
    private String handleNote;

    // 申请时间
    private Date applyDatetime;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 违章人档案
    private Archive applyUserArchive;

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Date getHappenDatetime() {
        return happenDatetime;
    }

    public void setHappenDatetime(Date happenDatetime) {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getPunishAmount() {
        return punishAmount;
    }

    public void setPunishAmount(Long punishAmount) {
        this.punishAmount = punishAmount;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Archive getApplyUserArchive() {
        return applyUserArchive;
    }

    public void setApplyUserArchive(Archive applyUserArchive) {
        this.applyUserArchive = applyUserArchive;
    }

}
