package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IDayRestAO;
import com.cdkj.loan.bo.IDayRestBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632680Req;
import com.cdkj.loan.dto.req.XN632680ReqDate;
import com.cdkj.loan.dto.res.XN632685Res;

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
            dayRest.setUpdater(req.getUpdater());
            dayRest.setUpdateDatetime(new Date());
            dayRest.setCompanyCode(sysUser.getCompanyCode());

            dayRestList.add(dayRest);
        }

        dayRestBO.saveDayRest(dayRestList);
    }

    @Override
    public XN632685Res queryDayRestList(DayRest condition) {
        List<DayRest> dayRestList = dayRestBO.queryDayRestList(condition);
        XN632685Res res = new XN632685Res();
        List<String> dateList = new ArrayList<String>();

        for (DayRest dayRest : dayRestList) {
            dateList.add(DateUtil.dateToStr(dayRest.getDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        }
        res.setDate(dateList);
        return res;
    }

    @Override
    public String queryCheckingList(DayRest condition) {

        return null;
    }
}
