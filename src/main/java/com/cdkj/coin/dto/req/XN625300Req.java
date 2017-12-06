package com.cdkj.coin.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tianlei on 2017/十二月/05.
 */
public class XN625300Req {

    @NotBlank
    private String userId;

    // 0=添加设置，1=取消设置
    @NotBlank
    private String opType;

    @NotBlank
    private String type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
