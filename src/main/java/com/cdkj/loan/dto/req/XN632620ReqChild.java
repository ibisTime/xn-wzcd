package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/***
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午12:59:55 
 * @history:
 */
public class XN632620ReqChild {

    @NotBlank
    private String startDatetime;

    @NotBlank
    private String endDatetime;

    private String totalHour;

    private String remark;

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

    public String getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(String totalHour) {
        this.totalHour = totalHour;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
