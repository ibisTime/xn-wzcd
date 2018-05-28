package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630156Req {

    @NotBlank
    private String id;// 节点流程序号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
