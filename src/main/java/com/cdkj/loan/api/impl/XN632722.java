package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632722Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改通告
 * @author: silver 
 * @since: 2018年6月8日 上午10:17:40 
 * @history:
 */
public class XN632722 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632722Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        noticeAO.editNotice(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632722Req.class);
        ObjValidater.validateReq(req);
    }
}
