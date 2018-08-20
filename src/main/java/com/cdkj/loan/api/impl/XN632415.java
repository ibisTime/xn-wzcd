package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBonusesListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BonusesList;
import com.cdkj.loan.dto.req.XN632415Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查奖金提成
 * @author: CYL 
 * @since: 2018年8月20日 下午7:14:46 
 * @history:
 */
public class XN632415 extends AProcessor {
    private IBonusesListAO bonusesListAO = SpringContextHolder
        .getBean(IBonusesListAO.class);

    private XN632415Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BonusesList condition = new BonusesList();
        condition.setSaleUser(req.getSaleUser());
        if (StringUtils.isNotBlank(req.getMonthStart())
                && StringUtils.isNotBlank(req.getMonthEnd())) {
            condition.setMonthStart(req.getMonthStart());
            condition.setMonthEnd(req.getMonthEnd());
        }

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBonusesListAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bonusesListAO.queryBonusesListPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632415Req.class);
        ObjValidater.validateReq(req);
    }

}
