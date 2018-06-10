package com.cdkj.loan.dto.req;

/**
 * 分页查询客户作废
 * @author: jiafr 
 * @since: 2018年6月10日 下午9:08:41 
 * @history:
 */
public class XN632195Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String applyUserName;

    private String bizCode;

    private String advanceFundDatetimeStart;

    private String advanceFundDatetimeEnd;

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getAdvanceFundDatetimeStart() {
        return advanceFundDatetimeStart;
    }

    public void setAdvanceFundDatetimeStart(String advanceFundDatetimeStart) {
        this.advanceFundDatetimeStart = advanceFundDatetimeStart;
    }

    public String getAdvanceFundDatetimeEnd() {
        return advanceFundDatetimeEnd;
    }

    public void setAdvanceFundDatetimeEnd(String advanceFundDatetimeEnd) {
        this.advanceFundDatetimeEnd = advanceFundDatetimeEnd;
    }

}
