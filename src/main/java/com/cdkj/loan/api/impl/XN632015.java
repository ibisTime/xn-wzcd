package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.dto.req.XN632015Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:32:09 
 * @history:
 */
public class XN632015 extends AProcessor {

    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN632015Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Area condition = new Area();
        if (StringUtils.isNotBlank(req.getId())) {
            condition.setId(StringValidater.toInteger(req.getId()));
        }
        condition.setAreaNoForQuery(req.getAreaNo());
        condition.setAreaNameForQuery(req.getAreaName());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IAreaAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return areaAO.queryAreaPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632015Req.class);
        ObjValidater.validateReq(req);
    }

}
