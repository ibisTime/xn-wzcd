package com.cdkj.loan.dto.req;

import org.springframework.beans.factory.annotation.Autowired;

public class XN632136Req {

    @Autowired
    private String code;// 编号

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
