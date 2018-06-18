package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.dto.req.XN632245Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询返点
 * @author: jiafr 
 * @since: 2018年6月18日 下午3:05:23 
 * @history:
 */
public class XN632245 extends AProcessor {

    private IRepointAO repointAO = SpringContextHolder
        .getBean(IRepointAO.class);

    private XN632245Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Repoint condition = new Repoint();
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyUserId(req.getApplyUserId());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCurNodeCode(req.getCurNodeCode());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IRepointAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repointAO.queryRepointPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632245Req.class);
        ObjValidater.validateReq(req);
    }
}
