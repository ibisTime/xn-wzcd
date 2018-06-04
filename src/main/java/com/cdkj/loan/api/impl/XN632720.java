package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632720Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增通告
 * @author: silver 
 * @since: 2018年6月4日 下午7:21:36 
 * @history:
 */
public class XN632720 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632720Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(noticeAO.addNotice(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632720Req.class);
        ObjValidater.validateReq(req);
    }
}
