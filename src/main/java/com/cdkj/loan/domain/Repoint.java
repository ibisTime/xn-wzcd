package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 返点表
* @author: jiafr 
* @since: 2018-06-18 14:11:55
* @history:
*/
public class Repoint extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 汽车经销商编号
    private String carDealerCode;

    // 收款账号编号
    private String bankcardCode;

    // 总金额
    private Long totalAmount;

    // 缘由
    private String reason;

    // 申请公司编号
    private String companyCode;

    // 申请人编号
    private String applyUserId;

    // 申请时间
    private Date applyDatetime;

    // 付款时间
    private Date payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 水单
    private String billPdf;

    // 付款备注
    private String payRemark;

    // 结算方式(来自汽车经销商)
    private String settleType;

    // 节点（0待打款1已打款）
    private String curNodeCode;

    /**************db properties*************/

    private Date applyDatetimeStart;

    private Date applyDatetimeEnd;

    private List<RepointDetail> repointDetailList;

    private String carDealerName;

    private String companyName;

    private String applyUserName;

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public List<RepointDetail> getRepointDetailList() {
        return repointDetailList;
    }

    public void setRepointDetailList(List<RepointDetail> repointDetailList) {
        this.repointDetailList = repointDetailList;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setPayBankcardCode(String payBankcardCode) {
        this.payBankcardCode = payBankcardCode;
    }

    public String getPayBankcardCode() {
        return payBankcardCode;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

}
