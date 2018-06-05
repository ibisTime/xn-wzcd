package com.cdkj.loan.dto.req;


public class XN632850ReqExp {

    // 起始时间
    private String startDatetime;

    // 截止时间
    private String endDatetime;

    // 工作单位
    private String companyName;

    // 职位
    private String position;

    // 离职原因
    private String leaveReason;

    // 证明人
    private String prover;

    // 证明人联系电话
    private String proverMobile;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getProver() {
        return prover;
    }

    public void setProver(String prover) {
        this.prover = prover;
    }

    public String getProverMobile() {
        return proverMobile;
    }

    public void setProverMobile(String proverMobile) {
        this.proverMobile = proverMobile;
    }
}
