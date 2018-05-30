package com.cdkj.loan.dto.req;

/**
 * 分页查询贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午1:41:00 
 * @history:
 */
public class XN632175Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -456247931245220624L;

    // 产品名称
    private String name;

    // 贷款银行
    private String loanBank;

    // 状态
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
