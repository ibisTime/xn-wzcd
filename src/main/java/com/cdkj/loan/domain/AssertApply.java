package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 办公用品/固定资产
* @author: jiafr 
* @since: 2018-06-06 17:50:27
* @history:
*/
public class AssertApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1=办公 2=固定资产)
    private String type;

    // 申请人
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    // 申请说明
    private String applyNote;

    // 是否印刷品（1是 2不是）
    private String isPrint;

    // 附件
    private String pdf;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /***************db properties*************/

    private String departmentCode;

    private Date startApplyDatetime;

    private Date endApplyDatetime;

    private List<AssertGoods> assertGoodsList;

    private List<AssertUser> assertUserList;

    public List<AssertGoods> getAssertGoodsList() {
        return assertGoodsList;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public void setAssertGoodsList(List<AssertGoods> assertGoodsList) {
        this.assertGoodsList = assertGoodsList;
    }

    public List<AssertUser> getAssertUserList() {
        return assertUserList;
    }

    public void setAssertUserList(List<AssertUser> assertUserList) {
        this.assertUserList = assertUserList;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Date getStartApplyDatetime() {
        return startApplyDatetime;
    }

    public void setStartApplyDatetime(Date startApplyDatetime) {
        this.startApplyDatetime = startApplyDatetime;
    }

    public Date getEndApplyDatetime() {
        return endApplyDatetime;
    }

    public void setEndApplyDatetime(Date endApplyDatetime) {
        this.endApplyDatetime = endApplyDatetime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }

    public String getIsPrint() {
        return isPrint;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getPdf() {
        return pdf;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
