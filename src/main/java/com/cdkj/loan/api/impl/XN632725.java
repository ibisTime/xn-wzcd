package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.INoticeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Notice;
import com.cdkj.loan.dto.req.XN632725Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询公告
 * @author: silver 
 * @since: 2018年6月4日 下午7:38:26 
 * @history:
 */
public class XN632725 extends AProcessor {

    private INoticeAO noticeAO = SpringContextHolder.getBean(INoticeAO.class);

    private XN632725Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Notice condition = new Notice();
        condition.setTitle(req.getTitle());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setUrgentStatus(req.getUrgentStatus());
        condition.setPublishDepartmentCode(req.getPublishDepartmentCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INoticeAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return noticeAO.queryNoticePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632725Req.class);
        ObjValidater.validateReq(req);
    }

}
