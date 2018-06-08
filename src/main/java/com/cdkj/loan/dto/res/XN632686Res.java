package com.cdkj.loan.dto.res;

import com.cdkj.loan.domain.Archive;

/**
 * 按月分页查询考勤汇总记录
 * @author: silver 
 * @since: 2018年6月8日 下午5:04:28 
 * @history:
 */
public class XN632686Res {
    // 档案
    private Archive archive;

    // 应出勤天数
    private Integer shouldCheckingDays;

    // 实际出勤天数
    private Integer actualCheckingDays;

    // 请假小时
    private Integer leaveHours;

    // 漏签次数
    private Integer suppleSignCount;

    // 出差小时

    // 公出小时

    // 加班小时
    private Integer overtimeHours;

    // 调休小时
    private Integer dayOffHours;

    // 年休小时
    private Integer annualLeaveHours;
}
