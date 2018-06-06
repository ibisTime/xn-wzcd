package com.cdkj.loan.dto.req;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午2:11:41 
 * @history:
 */
public class XN632625Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String applyUser;

    private String status;

    private String startDatetime;

    private String endDatetime;

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

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

}
