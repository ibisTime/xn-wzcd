package com.cdkj.loan.api.impl;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.ao.IDayRestAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.DayRest;
import com.cdkj.loan.dto.req.XN632686Req;
import com.cdkj.loan.enums.EBoolean;
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
        DayRest restCondition = new DayRest();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.strToDate(req.getDate(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        restCondition.setStartDatetime(DateUtil.getBeginTime(year, month));
        restCondition.setEndDatetime(DateUtil.getEndTime(year, month));
        restCondition.setIsRest(EBoolean.NO.getCode());

        Archive archiveCondition = new Archive();
        archiveCondition.setDepartmentCode(req.getDepartmentCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IArchiveAO.DEFAULT_ORDER_COLUMN;
        }
        archiveCondition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return dayRestAO.queryCheckingPage(start, limit, restCondition,
            archiveCondition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632686Req.class);
        ObjValidater.validateReq(req);
    }
}
