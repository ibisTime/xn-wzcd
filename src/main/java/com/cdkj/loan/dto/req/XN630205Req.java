package com.cdkj.loan.dto.req;

/**
 * 分页查询团队成员
 * @author: jiafr 
 * @since: 2018年6月8日 下午5:59:44 
 * @history:
 */
public class XN630205Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String teamCode;

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

}
