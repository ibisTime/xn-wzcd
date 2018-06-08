package com.cdkj.loan.api.impl;

import java.util.Calendar;

import com.cdkj.loan.ao.IDayRestAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.dto.req.XN632686Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 按月分页查询考勤汇总记录
 * @author: silver 
 * @since: 2018年6月4日 下午7:45:07 
 * @history:
 */
public class XN632686 extends AProcessor {

    private IDayRestAO dayRestAO = SpringContextHolder
        .getBean(IDayRestAO.class);

    private XN632686Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        DayRest condition = new DayRest();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.strToDate(req.getDate(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        condition.setStartDatetime(DateUtil.getBeginTime(year, month));
        condition.setEndDatetime(DateUtil.getEndTime(year, month));
        return dayRestAO.queryDayRestList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632686Req.class);
        ObjValidater.validateReq(req);
    }

}
