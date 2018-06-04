package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632726Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询公告
 * @author: silver 
 * @since: 2018年6月4日 下午7:42:58 
 * @history:
 */
public class XN632726 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632726Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return noticeAO.getNotice(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632726Req.class);
        ObjValidater.validateReq(req);
    }
}
