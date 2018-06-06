package com.cdkj.loan.dto.req;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:23:21 
 * @history:
 */
public class XN632660ReqDetail {

    // 用户编号
    private String userId;

    // 备注
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
