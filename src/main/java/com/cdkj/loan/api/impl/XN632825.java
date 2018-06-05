package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IArchiveLocationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ArchiveLocation;
import com.cdkj.loan.dto.req.XN632825Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询档案存放位置
 * @author: jiafr 
 * @since: 2018年6月5日 下午6:58:14 
 * @history:
 */
public class XN632825 extends AProcessor {

    private IArchiveLocationAO archiveLocationAO = SpringContextHolder
        .getBean(IArchiveLocationAO.class);

    private XN632825Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ArchiveLocation condition = new ArchiveLocation();
        condition.setName(req.getName());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IArchiveLocationAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return archiveLocationAO.queryArchiveLocationPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632825Req.class);
        ObjValidater.validateReq(req);
    }
}
