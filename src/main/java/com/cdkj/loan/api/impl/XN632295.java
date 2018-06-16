package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepointDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.dto.req.XN632295Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询返点明细
 * @author: jiafr 
 * @since: 2018年6月16日 下午2:37:17 
 * @history:
 */
public class XN632295 extends AProcessor {

    private IRepointDetailAO repointDetailAO = SpringContextHolder
        .getBean(IRepointDetailAO.class);

    private XN632295Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepointDetail condition = new RepointDetail();
        condition.setUseMoneyPurpose(req.getUseMoneyPurpose());
        condition.setBudgetCode(req.getBudgetOrder());
        condition.setCarDealerCode(req.getCarDealerCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IRepointDetailAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repointDetailAO.queryRepointDetailPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632295Req.class);
        ObjValidater.validateReq(req);
    }
}
