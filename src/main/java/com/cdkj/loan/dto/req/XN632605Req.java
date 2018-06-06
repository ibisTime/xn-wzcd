package com.cdkj.loan.dto.req;

/**
 * 分页查询补签
 * @author: silver 
 * @since: 2018年6月6日 下午12:30:48 
 * @history:
 */
public class XN632605Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5933298866541905618L;

    // 申请人编号
    private String applyUser;

    // 开始时间
    private String startDatetime;

    // 结束时间
    private String endDatetime;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
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
