package com.cdkj.loan.dto.req;

/**
 * 补签明细
 * @author: silver 
 * @since: 2018年6月6日 下午12:01:42 
 * @history:
 */
public class XN632600ReqDetail {
    // 漏签时间
    private String suppleDatetime;

    // 备注
    private String remark;

    public String getSuppleDatetime() {
        return suppleDatetime;
    }

    public void setSuppleDatetime(String suppleDatetime) {
        this.suppleDatetime = suppleDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
