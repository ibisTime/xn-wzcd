package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 获取休假时间
 * @author: silver 
 * @since: 2018年6月6日 下午10:52:30 
 * @history:
 */
public class XN632892Req {
    // 申请人
    @NotBlank
    private String applyUser;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

}
