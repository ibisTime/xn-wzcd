package com.cdkj.loan.dto.req;

/**
 * 分页查询银行
 * @author: silver 
 * @since: 2018年5月27日 下午5:36:00 
 * @history:
 */
public class XN632035Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -2359314794624013050L;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 状态
    private String status;

    // 分支
    private String subbranch;

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
