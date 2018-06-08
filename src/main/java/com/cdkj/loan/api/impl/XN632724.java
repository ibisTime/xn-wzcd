package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632724Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 撤下公告
 * @author: silver 
 * @since: 2018年6月8日 上午10:38:32 
 * @history:
 */
public class XN632724 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632724Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        noticeAO.removeNotice(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632724Req.class);
        ObjValidater.validateReq(req);
    }
}
