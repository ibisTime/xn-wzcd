package com.cdkj.loan.dto.req;

/**
 * 分页查询加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午9:26:40 
 * @history:
 */
public class XN632615Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String applyUser;

    private String status;

    private String startApplyDatetime;

    private String endApplyDatetime;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartApplyDatetime() {
        return startApplyDatetime;
    }

    public void setStartApplyDatetime(String startApplyDatetime) {
        this.startApplyDatetime = startApplyDatetime;
    }

    public String getEndApplyDatetime() {
        return endApplyDatetime;
    }

    public void setEndApplyDatetime(String endApplyDatetime) {
        this.endApplyDatetime = endApplyDatetime;
    }

}
