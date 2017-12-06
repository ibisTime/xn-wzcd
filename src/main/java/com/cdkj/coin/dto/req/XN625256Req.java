package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tianlei on 2017/十一月/23.
 */
public class XN625256Req {

    @NotBlank
    private String master;

    private String visitor;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }
}
