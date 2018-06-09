package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IDayRestAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDayRestBO;
import com.cdkj.loan.bo.ILeaveApplyBO;
import com.cdkj.loan.bo.IOvertimeApplyBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISuppleSignApplyBO;
import com.cdkj.loan.bo.ITravelApplyBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SuppleSignApply;
import com.cdkj.loan.dto.req.XN632680Req;
import com.cdkj.loan.dto.req.XN632680ReqDate;
import com.cdkj.loan.dto.res.XN632685Res;
import com.cdkj.loan.dto.res.XN632686Res;
import com.cdkj.loan.enums.ELeaveApplyType;

/**
 * 休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:51:30 
 * @history:
 */
@Service
public class DayRestAOImpl implements IDayRestAO {

    @Autowired
    private IDayRestBO dayRestBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private ILeaveApplyBO leaveApplyBO;

    @Autowired
    private ISuppleSignApplyBO suppleSignApplyBO;

    @Autowired
    private ITravelApplyBO travelApplyBO;

    @Autowired
    private IOvertimeApplyBO overtimeApplyBO;

    @Override
    public void addDayRest(XN632680Req req) {
        // 删除之前的记录
        dayRestBO.removeDayRest(DateUtil.strToDate(req.getOperateDate(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        // 添加新记录
        SYSUser sysUser = sysUserBO.getUser(req.getUpdater());
        List<DayRest> dayRestList = new ArrayList<DayRest>();
        for (XN632680ReqDate date : req.getDateList()) {
            DayRest dayRest = new DayRest();
            dayRest.setDate(DateUtil.strToDate(date.getRestDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            dayRest.setIsRest(date.getIsRest());
            dayRest.setUpdater(req.getUpdater());
            dayRest.setUpdateDatetime(new Date());
            dayRest.setCompanyCode(sysUser.getCompanyCode());

            dayRestList.add(dayRest);
        }

        dayRestBO.saveDayRest(dayRestList);
    }

    @Override
    public List<XN632685Res> queryDayRestList(DayRest condition) {
        List<DayRest> dayRestList = dayRestBO.queryDayRestList(condition);
        List<XN632685Res> resList = new ArrayList<XN632685Res>();

        for (DayRest dayRest : dayRestList) {
            XN632685Res res = new XN632685Res();
            res.setDate(DateUtil.dateToStr(dayRest.getDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            res.setIsRest(dayRest.getIsRest());
            resList.add(res);
        }
        return resList;
    }

    @Override
    public Paginable<XN632686Res> queryCheckingPage(int start, int limit,
            DayRest condition) {
        Archive archiveCondition = new Archive();
        Paginable<Archive> page = archiveBO.getPaginable(start, limit,
            archiveCondition);
        List<Archive> archiveList = page.getList();
        // 应出勤天数
        Long shouldCheckingDays = dayRestBO.getTotalCount(condition);

        Paginable<XN632686Res> resPage = new Page<XN632686Res>(start, limit,
            archiveBO.getTotalCount(archiveCondition));
        List<XN632686Res> resList = new ArrayList<XN632686Res>();

        for (Archive archive : archiveList) {
            XN632686Res res = new XN632686Res();
            res.setDepartmentName(archive.getDepartmentName());
            res.setRealName(archive.getRealName());
            res.setJobNo(archive.getJobNo());
            // 应出勤天数
            res.setShouldCheckingDays(shouldCheckingDays);

            // 请假小时,type:1
            Long leaveHours = leaveApplyBO.getTotalHour(archive.getUserId(),
                ELeaveApplyType.SHIJIA.getCode(), condition.getStartDatetime(),
                condition.getStartDatetime());
            res.setLeaveHours(leaveHours);

            // 请假天数
            Long leaveDays = 0L;
            if (leaveHours > 0 && leaveHours % 8 == 0) {
                leaveDays = leaveHours / 8;
            } else if (leaveHours > 0 && leaveHours % 8 != 0) {
                leaveDays = (leaveHours / 8) + 1;
            }

            // 实际出勤天数
            res.setActualCheckingDays(shouldCheckingDays - leaveDays);

            // 漏签次数
            SuppleSignApply suppleCondition = new SuppleSignApply();
            suppleCondition.setApplyUser(archive.getUserId());
            res.setSuppleSignCount(
                suppleSignApplyBO.getTotalCount(suppleCondition));

            // 出差、公出小时
            res.setTravelHours(
                travelApplyBO.getTravelApplyTotalHour(archive.getUserId(), "1",
                    condition.getStartDatetime(), condition.getEndDatetime()));
            res.setOfficeTravelHours(
                travelApplyBO.getTravelApplyTotalHour(archive.getUserId(), "2",
                    condition.getStartDatetime(), condition.getEndDatetime()));

            // 加班小时
            res.setOvertimeHours(
                overtimeApplyBO.getOvertimeTotalHour(archive.getUserId(),
                    condition.getStartDatetime(), condition.getEndDatetime()));

            // 调休小时
            res.setDayOffHours(leaveApplyBO.getTotalHour(archive.getUserId(),
                ELeaveApplyType.TIAOXIU.getCode(), condition.getStartDatetime(),
                condition.getStartDatetime()));

            // 年休小时
            res.setDayOffHours(leaveApplyBO.getTotalHour(archive.getUserId(),
                ELeaveApplyType.NIANXIUJIA.getCode(),
                condition.getStartDatetime(), condition.getStartDatetime()));
            resList.add(res);
        }
        resPage.setList(resList);
        return resPage;
    }
}
