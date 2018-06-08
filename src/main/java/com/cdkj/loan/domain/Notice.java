package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 公告管理
 * @author: silver 
 * @since: 2018年6月4日 下午5:07:36 
 * @history:
 */
public class Notice extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 公告标题
    private String title;

    // 公告类型
    private String type;

    // 紧急程度
    private String urgentStatus;

    // 发布部门
    private String publishDepartmentCode;

    // 公告内容
    private String content;

    // 发布时间
    private Date publishDatetime;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 发布部门
    private String publishDepartmentName;

    // 公告范围
    private List<ScopePeople> scopePeopleList;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUrgentStatus(String urgentStatus) {
        this.urgentStatus = urgentStatus;
    }

    public String getUrgentStatus() {
        return urgentStatus;
    }

    public void setPublishDepartmentCode(String publishDepartmentCode) {
        this.publishDepartmentCode = publishDepartmentCode;
    }

    public String getPublishDepartmentCode() {
        return publishDepartmentCode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
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

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
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

    public String getPublishDepartmentName() {
        return publishDepartmentName;
    }

    public void setPublishDepartmentName(String publishDepartmentName) {
        this.publishDepartmentName = publishDepartmentName;
    }

    public List<ScopePeople> getScopePeopleList() {
        return scopePeopleList;
    }

    public void setScopePeopleList(List<ScopePeople> scopePeopleList) {
        this.scopePeopleList = scopePeopleList;
    }

}
