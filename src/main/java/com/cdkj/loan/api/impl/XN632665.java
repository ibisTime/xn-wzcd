package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IWelfareApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.WelfareApply;
import com.cdkj.loan.dto.req.XN632665Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:34:56 
 * @history:
 */
public class XN632665 extends AProcessor {
    private IWelfareApplyAO welfareApplyAO = SpringContextHolder
        .getBean(IWelfareApplyAO.class);

    private XN632665Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        WelfareApply condition = new WelfareApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IWelfareApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return welfareApplyAO.queryWelfareApplyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632665Req.class);
        ObjValidater.validateReq(req);
    }
}
