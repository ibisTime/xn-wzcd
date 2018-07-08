package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.dto.req.XN632727Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询公告
 * @author: silver 
 * @since: 2018年6月4日 下午7:45:07 
 * @history:
 */
public class XN632727 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632727Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Notice condition = new Notice();
        condition.setTitle(req.getTitle());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setUrgentStatus(req.getUrgentStatus());
        condition.setPublishDepartmentCode(req.getPublishDepartmentCode());
        return noticeAO.queryNoticeList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632727Req.class);
        ObjValidater.validateReq(req);
    }

}
