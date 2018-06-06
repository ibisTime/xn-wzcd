package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IOvertimeApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.OvertimeApply;
import com.cdkj.loan.dto.req.XN632610Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增加班申请
 * @author: jiafr 
 * @since: 2018年6月6日 上午12:17:10 
 * @history:
 */
public class XN632610 extends AProcessor {
    private IOvertimeApplyAO overtimeApplyAO = SpringContextHolder
        .getBean(IOvertimeApplyAO.class);

    private XN632610Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OvertimeApply data = new OvertimeApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        Date start = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_2);
        data.setStartDatetime(start);
        Date end = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_2);
        data.setEndDatetime(end);
        data.setReason(req.getReason());
        String time = String.valueOf((end.getTime() - start.getTime())
                / (1000 * 60 * 60));
        data.setTotalHour(time);
        data.setUpdater(req.getUpdater());
        data.setStatus("0");
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        return new PKCodeRes(overtimeApplyAO.addOvertimeApply(data));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632610Req.class);
        ObjValidater.validateReq(req);
    }

}
