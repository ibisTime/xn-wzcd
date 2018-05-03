package com.cdkj.loan.dto.req;

public class XN630505Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String mobile;// 手机号

    private String idNo;// 身份证号

    private String realName;// 真实姓名

    private String status;// 状态

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
