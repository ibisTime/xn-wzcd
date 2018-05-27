package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

public class SYSBizLog extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 2099380862896285572L;

    private int id;// 序号

    private String parentOrder;// 上级订单编号

    private String refType;// 关联订单类型

    private String refOrder;// 关联订单编号

    private String dealNode;// 处理节点

    private String dealNote;// 处理说明

    private String status;// 状态(0 待处理 1 已处理)

    private String operateRole;// 操作角色

    private String operator;// 操作人

    private String operatorName;// 操作人姓名

    private String operatorMobile;// 操作人手机号

    private Date startDatetime;// 操作开始时间

    private Date endDatetime;// 操作结束时间

    private String speedTime;// 花费时间

    /*-------------辅助字段---------------*/

    private Date startDatetimeStart;

    private Date endDatetimeEnd;

    private String operatorNameForQuery;// 操作人姓名模糊查

    private String operatorMobileForQuery;// 操作人手机号模糊查

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(String parentOrder) {
        this.parentOrder = parentOrder;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefOrder() {
        return refOrder;
    }

    public void setRefOrder(String refOrder) {
        this.refOrder = refOrder;
    }

    public String getDealNode() {
        return dealNode;
    }

    public void setDealNode(String dealNode) {
        this.dealNode = dealNode;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperateRole() {
        return operateRole;
    }

    public void setOperateRole(String operateRole) {
        this.operateRole = operateRole;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorMobile() {
        return operatorMobile;
    }

    public void setOperatorMobile(String operatorMobile) {
        this.operatorMobile = operatorMobile;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getSpeedTime() {
        return speedTime;
    }

    public void setSpeedTime(String speedTime) {
        this.speedTime = speedTime;
    }

    public String getOperatorNameForQuery() {
        return operatorNameForQuery;
    }

    public void setOperatorNameForQuery(String operatorNameForQuery) {
        this.operatorNameForQuery = operatorNameForQuery;
    }

    public String getOperatorMobileForQuery() {
        return operatorMobileForQuery;
    }

    public void setOperatorMobileForQuery(String operatorMobileForQuery) {
        this.operatorMobileForQuery = operatorMobileForQuery;
    }

    public Date getStartDatetimeStart() {
        return startDatetimeStart;
    }

    public void setStartDatetimeStart(Date startDatetimeStart) {
        this.startDatetimeStart = startDatetimeStart;
    }

    public Date getEndDatetimeEnd() {
        return endDatetimeEnd;
    }

    public void setEndDatetimeEnd(Date endDatetimeEnd) {
        this.endDatetimeEnd = endDatetimeEnd;
    }

}
