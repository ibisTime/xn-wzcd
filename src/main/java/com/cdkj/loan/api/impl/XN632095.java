package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ITableExportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.TableExport;
import com.cdkj.loan.dto.req.XN632095Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 表格导出分页查
 * @author: CYL 
 * @since: 2018年8月4日 下午8:22:27 
 * @history:
 */
public class XN632095 extends AProcessor {
    private ITableExportAO tableExportAO = SpringContextHolder
        .getBean(ITableExportAO.class);

    private XN632095Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        TableExport condition = new TableExport();
        condition.setUrl(req.getUrl());
        condition.setOperator(req.getOperator());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ITableExportAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return tableExportAO.queryTableExportPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632095Req.class);
        ObjValidater.validateReq(req);
    }

}
