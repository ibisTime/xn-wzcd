package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 订单分页查询
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN808065Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号(选填)
    private String code;

    // 收件人姓名(选填)
    private String receiver;

    // 收件人电话(选填)
    private String reMobile;

    // 下单人（选填）
    private String applyUser;

    // 状态（选填）
    private String status;

    // 支付类型（选填）
    private String payType;

    // 支付组号（选填）
    private String payGroup;

    // 橙账本流水号（选填）
    private String payCode;

    // 发货人（选填）
    private String deliverer;

    // 物流单号（选填）
    private String logisticsCode;

    // 物流公司（选填）
    private String logisticsCompany;

    // 状态List
    private List<String> statusList;

    // 支付时间起
    private String payDatetimeStart;

    // 支付时间止
    private String payDatetimeEnd;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayDatetimeStart() {
        return payDatetimeStart;
    }

    public void setPayDatetimeStart(String payDatetimeStart) {
        this.payDatetimeStart = payDatetimeStart;
    }

    public String getPayDatetimeEnd() {
        return payDatetimeEnd;
    }

    public void setPayDatetimeEnd(String payDatetimeEnd) {
        this.payDatetimeEnd = payDatetimeEnd;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReMobile() {
        return reMobile;
    }

    public void setReMobile(String reMobile) {
        this.reMobile = reMobile;
    }
}
