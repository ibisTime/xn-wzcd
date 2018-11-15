package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630418Req {

    // 品牌标识
    private String brandId;

    // 更新人
    @NotBlank
    private String updater;

    private String cdkjToken;

    public String getCdkjToken() {
        return cdkjToken;
    }

    public void setCdkjToken(String cdkjToken) {
        this.cdkjToken = cdkjToken;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
