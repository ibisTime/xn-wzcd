package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 合同管理
* @author: jiafr 
* @since: 2018-06-05 20:10:57
* @history:
*/
public class Contract extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 合同类型
    private String type;

    // 用户编号
    private String userId;

    // 档案编号
    private String archiveCode;

    // 合同编号
    private String contractNo;

    // 开始日期
    private Date startDatetime;

    // 结束日期
    private Date endDatetime;

    // 合同附件
    private String pdf;

    // 说明
    private String remark;

    /*-------辅助字段-------*/

    // 人事档案
    private Archive archive;

    // 预警开始时间
    private Date warnDatetimeStart;

    // 结束时间
    private Date warnDatetimeEnd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getWarnDatetimeStart() {
        return warnDatetimeStart;
    }

    public void setWarnDatetimeStart(Date warnDatetimeStart) {
        this.warnDatetimeStart = warnDatetimeStart;
    }

    public Date getWarnDatetimeEnd() {
        return warnDatetimeEnd;
    }

    public void setWarnDatetimeEnd(Date warnDatetimeEnd) {
        this.warnDatetimeEnd = warnDatetimeEnd;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
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

    public void setArchiveCode(String archiveCode) {
        this.archiveCode = archiveCode;
    }

    public String getArchiveCode() {
        return archiveCode;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractNo() {
        return contractNo;
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

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getPdf() {
        return pdf;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
