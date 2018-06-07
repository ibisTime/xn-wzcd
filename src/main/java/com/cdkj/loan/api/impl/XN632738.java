package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.INoticeReadAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.NoticeRead;
import com.cdkj.loan.dto.req.XN632738Req;
import com.cdkj.loan.enums.ENoticeRegime;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询我的制度
 * @author: silver 
 * @since: 2018年6月7日 下午6:17:55 
 * @history:
 */
public class XN632738 extends AProcessor {

    private INoticeReadAO noticeReadAO = SpringContextHolder
        .getBean(INoticeReadAO.class);

    private XN632738Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        NoticeRead condition = new NoticeRead();
        condition.setUserId(req.getUserId());
        condition.setRefType(ENoticeRegime.REMIGE.getCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INoticeReadAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return noticeReadAO.queryNoticeReadPage(start, limit, condition,
            ENoticeRegime.REMIGE.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632738Req.class);
        ObjValidater.validateReq(req);
    }

}
