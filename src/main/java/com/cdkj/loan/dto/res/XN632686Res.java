package com.cdkj.loan.dto.res;

/**
 * 按月分页查询考勤汇总记录
 * @author: silver 
 * @since: 2018年6月8日 下午5:04:28 
 * @history:
 */
public class XN632686Res {

    // 部门
    private String departmentName;

    // 姓名
    private String realName;

    // 工号
    private String jobNo;

    // 应出勤天数
    private Long shouldCheckingDays;

    // 实际出勤天数
    private Long actualCheckingDays;

    // 请假小时
    private Long leaveHours;

    // 漏签次数
    private Long suppleSignCount;

    // 出差小时
    private Long travelHours;

    // 公出小时
    private Long officeTravelHours;

    // 加班小时
    private Long overtimeHours;

    // 调休小时
    private Long dayOffHours;

    // 年休小时
    private Long annualLeaveHours;

    public Long getShouldCheckingDays() {
        return shouldCheckingDays;
    }

    public void setShouldCheckingDays(Long shouldCheckingDays) {
        this.shouldCheckingDays = shouldCheckingDays;
    }

    public Long getActualCheckingDays() {
        return actualCheckingDays;
    }

    public void setActualCheckingDays(Long actualCheckingDays) {
        this.actualCheckingDays = actualCheckingDays;
    }

    public Long getLeaveHours() {
        return leaveHours;
    }

    public void setLeaveHours(Long leaveHours) {
        this.leaveHours = leaveHours;
    }

    public Long getSuppleSignCount() {
        return suppleSignCount;
    }

    public void setSuppleSignCount(Long suppleSignCount) {
        this.suppleSignCount = suppleSignCount;
    }

    public Long getTravelHours() {
        return travelHours;
    }

    public void setTravelHours(Long travelHours) {
        this.travelHours = travelHours;
    }

    public Long getOfficeTravelHours() {
        return officeTravelHours;
    }

    public void setOfficeTravelHours(Long officeTravelHours) {
        this.officeTravelHours = officeTravelHours;
    }

    public Long getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(Long overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Long getDayOffHours() {
        return dayOffHours;
    }

    public void setDayOffHours(Long dayOffHours) {
        this.dayOffHours = dayOffHours;
    }

    public Long getAnnualLeaveHours() {
        return annualLeaveHours;
    }

    public void setAnnualLeaveHours(Long annualLeaveHours) {
        this.annualLeaveHours = annualLeaveHours;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }
}
