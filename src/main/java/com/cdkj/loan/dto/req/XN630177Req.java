package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630177Req {

    @NotBlank
    private String id;// id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
