package com.cdkj.loan.dto.res;

public class XN630091Res {
    // 上传凭证
    private String uploadToken;

    public XN630091Res() {
    }

    public XN630091Res(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }
}
