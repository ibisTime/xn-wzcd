package com.cdkj.loan.dto.req;

/**
 * 分页查询返点支付
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:22:25 
 * @history:
 */
public class XN632315Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String teamCode;

    private String status;

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
