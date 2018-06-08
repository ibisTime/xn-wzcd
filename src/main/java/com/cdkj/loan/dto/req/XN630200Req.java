package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增业务团队成员
 * @author: jiafr 
 * @since: 2018年6月8日 下午5:13:29 
 * @history:
 */
public class XN630200Req {

    @NotBlank
    private String userId;

    @NotBlank
    private String teamCode;

    @NotBlank
    private String updater;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
