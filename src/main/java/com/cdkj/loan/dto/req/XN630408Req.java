package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630408Req {

    @NotBlank
    private String updater;

    private String cdkjToken;

    public String getCdkjToken() {
        return cdkjToken;
    }

    public void setCdkjToken(String cdkjToken) {
        this.cdkjToken = cdkjToken;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
