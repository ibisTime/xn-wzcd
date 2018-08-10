package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITableExportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632090Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 表格导出
 * @author: CYL 
 * @since: 2018年8月4日 下午8:22:27 
 * @history:
 */
public class XN632090 extends AProcessor {
    private ITableExportAO tableExportAO = SpringContextHolder
        .getBean(ITableExportAO.class);

    private XN632090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return tableExportAO.addTableExport(req.getUrl(), req.getOperator());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632090Req.class);
        ObjValidater.validateReq(req);
    }

}
