/**
 * @Title Invoice.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 下午7:32:38 
 * @version V1.0   
 */
package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * @author: haiqingzheng 
 * @since: 2016年11月16日 上午11:16:07 
 * @history:
 */
public class Order extends ABaseDO {

    private static final long serialVersionUID = -6380104639754144884L;

    // 编号
    private String code;

    // 还款业务编号
    private String repayBizCode;

    // 还款卡编号
    private String bankcardCode;

    // 收件人姓名
    private String receiver;

    // 收件人电话
    private String reMobile;

    // 收货地址
    private String reAddress;

    // 下单人
    private String applyUser;

    // 申请备注
    private String applyNote;

    // 申请时间
    private Date applyDatetime;

    // 订单金额(人民币)
    private Long amount;

    // 运费
    private Long yunfei;

    // 首付比例
    private double sfRate;

    // 首付金额
    private Long sfAmount;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private int periods;

    // 银行利率
    private double bankRate;

    // 抵扣人民币
    private Long dkAmount;

    // 使用积分
    private Long dkJfAmount;

    // 状态
    private String status;

    // 支付方式
    private String payType;

    // 支付组号
    private String payGroup;

    // 渠道号
    private String payCode;

    // 实际支付时间
    private Date payDatetime;

    // 实际支付金额
    private Long payAmount;

    // 发货人
    private String deliverer;

    // 发货时间
    private Date deliveryDatetime;

    // 物流单号
    private String logisticsCode;

    // 物流公司
    private String logisticsCompany;

    // 物流单
    private String pdf;

    // 签收人
    private String signer;

    // 签收时间
    private Date signDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // *************dp properties **************

    // 编号
    private String codeQuery;

    // 申请开始时间起
    private Date applyDatetimeStart;

    // 申请开始时间止
    private Date applyDatetimeEnd;

    // 支付时间起
    private Date payDatetimeStart;

    // 支付时间止
    private Date payDatetimeEnd;

    // 订单产品详情列表
    List<ProductOrder> productOrderList;

    // 下单人
    private User cuser;

    // 状态list
    private List<String> statusList;

    // 前端屏蔽 用户删除状态
    private String frontStatus;

    // 产品信息
    private Product product;

    // 规格信息
    private ProductSpecs productSpecs;

    // 发货时间起
    private Date deliveryDatetimeStart;

    // 发货时间止
    private Date deliveryDatetimeEnd;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
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

    public String getReAddress() {
        return reAddress;
    }

    public void setReAddress(String reAddress) {
        this.reAddress = reAddress;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getYunfei() {
        return yunfei;
    }

    public void setYunfei(Long yunfei) {
        this.yunfei = yunfei;
    }

    public Long getDkAmount() {
        return dkAmount;
    }

    public void setDkAmount(Long dkAmount) {
        this.dkAmount = dkAmount;
    }

    public Long getDkJfAmount() {
        return dkJfAmount;
    }

    public void setDkJfAmount(Long dkJfAmount) {
        this.dkJfAmount = dkJfAmount;
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

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public Date getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setDeliveryDatetime(Date deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
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

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public Date getSignDatetime() {
        return signDatetime;
    }

    public void setSignDatetime(Date signDatetime) {
        this.signDatetime = signDatetime;
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

    public String getCodeQuery() {
        return codeQuery;
    }

    public void setCodeQuery(String codeQuery) {
        this.codeQuery = codeQuery;
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

    public Date getPayDatetimeStart() {
        return payDatetimeStart;
    }

    public void setPayDatetimeStart(Date payDatetimeStart) {
        this.payDatetimeStart = payDatetimeStart;
    }

    public Date getPayDatetimeEnd() {
        return payDatetimeEnd;
    }

    public void setPayDatetimeEnd(Date payDatetimeEnd) {
        this.payDatetimeEnd = payDatetimeEnd;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public User getCuser() {
        return cuser;
    }

    public void setCuser(User cuser) {
        this.cuser = cuser;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getFrontStatus() {
        return frontStatus;
    }

    public void setFrontStatus(String frontStatus) {
        this.frontStatus = frontStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSpecs getProductSpecs() {
        return productSpecs;
    }

    public void setProductSpecs(ProductSpecs productSpecs) {
        this.productSpecs = productSpecs;
    }

    public Date getDeliveryDatetimeStart() {
        return deliveryDatetimeStart;
    }

    public void setDeliveryDatetimeStart(Date deliveryDatetimeStart) {
        this.deliveryDatetimeStart = deliveryDatetimeStart;
    }

    public Date getDeliveryDatetimeEnd() {
        return deliveryDatetimeEnd;
    }

    public void setDeliveryDatetimeEnd(Date deliveryDatetimeEnd) {
        this.deliveryDatetimeEnd = deliveryDatetimeEnd;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

}
