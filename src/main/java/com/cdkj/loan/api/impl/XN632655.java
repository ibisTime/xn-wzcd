package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAskForApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AskForApply;
import com.cdkj.loan.dto.req.XN632655Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查
 * @author: CYL 
 * @since: 2018年6月6日 下午5:37:39 
 * @history:
 */
public class XN632655 extends AProcessor {
    private IAskForApplyAO askForApplyAO = SpringContextHolder
        .getBean(IAskForApplyAO.class);

    private XN632655Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AskForApply condition = new AskForApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IAskForApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return askForApplyAO.queryAskForApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632655Req.class);
        ObjValidater.validateReq(req);
    }

}
