package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeReadAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632721Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 阅读公告
 * @author: silver 
 * @since: 2018年6月7日 下午5:53:38 
 * @history:
 */
public class XN632721 extends AProcessor {

    private INoticeReadAO noticeReadAO = SpringContextHolder
        .getBean(INoticeReadAO.class);

    private XN632721Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return noticeReadAO
            .getNoticeRead(StringValidater.toInteger(req.getId()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632721Req.class);
        ObjValidater.validateReq(req);
    }
}
