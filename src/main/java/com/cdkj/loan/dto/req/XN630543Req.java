package com.cdkj.loan.dto.req;

public class XN630543Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String userId;// 用户编号

    private String refType;// 类型，0=商品，1=车贷

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
