package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICompCategoryAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.dto.req.XN632745Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午10:11:53 
 * @history:
 */
public class XN632745 extends AProcessor {
    private ICompCategoryAO compCategoryAO = SpringContextHolder
        .getBean(ICompCategoryAO.class);

    private XN632745Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CompCategory condition = new CompCategory();
        condition.setName(req.getName());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompCategoryAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return compCategoryAO.queryCompCategoryPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632745Req.class);
        ObjValidater.validateReq(req);
    }

}
