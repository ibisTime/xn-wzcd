package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.dto.req.XN630405Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*分页查询*/

public class XN630405 extends AProcessor {

    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630405Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Brand brand = new Brand();
        brand.setName(req.getName());
        brand.setLetter(req.getLetter());
        brand.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBrandAO.DEFAULT_ORDER_COLUMN;
        }
        brand.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return brandAO.queryBrandPage(start, limit, brand);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630405Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
