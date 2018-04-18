package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICNavigateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CNavigate;
import com.cdkj.loan.dto.req.XN805805Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 分页查询导航
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN805805 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805805Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CNavigate condition = new CNavigate();
        condition.setName(req.getName());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setLocation(req.getLocation());
        condition.setBelong(req.getBelong());
        condition.setParentCode(req.getParentCode());
        condition.setContentType(req.getContentType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        condition.setIsFront(EBoolean.NO.getCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ICNavigateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return cNavigateAO.queryCNavigatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805805Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }
}
