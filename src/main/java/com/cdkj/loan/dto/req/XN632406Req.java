package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632406Req {

    // id
    @NotBlank
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
