package com.cdkj.loan.dto.req;

/**
 * 分页查询出库
 * @author: silver 
 * @since: 2018年6月5日 下午5:05:25 
 * @history:
 */
public class XN632895Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5933298866541905618L;

    // 申请人编号
    private String applyUser;

    // 请假类别
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
