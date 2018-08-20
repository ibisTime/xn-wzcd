package com.cdkj.loan.dto.req;

public class XN632405Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7416893983435548075L;

    // 是否自主开发
    private String isSelfDevelop;

    // 留存月数
    private String retainMonths;

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getRetainMonths() {
        return retainMonths;
    }

    public void setRetainMonths(String retainMonths) {
        this.retainMonths = retainMonths;
    }

}
