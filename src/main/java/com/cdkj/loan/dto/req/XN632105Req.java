package com.cdkj.loan.dto.req;

public class XN632105Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5780013307270124748L;

    private String companyCode;// 业务公司编号

    private String applyDatetimeStart;// 申请时间起

    private String applyDatetimeEnd;// 申请时间止

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

}
