package com.cdkj.loan.dto.req;

/**
 * 银行合同导入分页查
 * @author: CYL 
 * @since: 2018年7月24日 下午7:50:35 
 * @history:
 */
public class XN632255Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -5403598301236699444L;

    // 合同号
    private String contractCode;

    // 客户姓名
    private String customerName;

    // 银行
    private String bankCode;

    // 导入日期
    private String importDatetime;

    // 状态
    private String status;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
