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

    // 状态
    private String status;

    // 开始时间
    private String applyDatetimeStart;

    // 结束时间
    private String applyDatetimeEnd;

    public String getApplyUser() {
        return applyUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

}
