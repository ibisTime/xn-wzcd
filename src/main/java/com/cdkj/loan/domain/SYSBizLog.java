package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

public class SYSBizLog extends ABaseDO {

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

    private String operatorNameForQuery;// 操作人姓名模糊查

    private String operatorMobileForQuery;// 操作人手机号模糊查

    private String roleCode;// 角色编号

    private String teamCode;// 团队编号

    private String userName;// 客户姓名

    private String loanBank;// 贷款银行编号

    private String bizType;// 业务种类(新车，二手车)

    private String departmentName;// 部门名称

    private String bizOrderType;// 业务单类型（ 征信单 准入单 还款业务 出差申请）

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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBizOrderType() {
        return bizOrderType;
    }

    public void setBizOrderType(String bizOrderType) {
        this.bizOrderType = bizOrderType;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

}
