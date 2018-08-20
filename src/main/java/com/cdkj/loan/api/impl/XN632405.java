package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISysBonusesAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SysBonuses;
import com.cdkj.loan.dto.req.XN632405Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查奖金提成配置
 * @author: CYL 
 * @since: 2018年8月20日 下午7:14:46 
 * @history:
 */
public class XN632405 extends AProcessor {
    private ISysBonusesAO sysBonusesAO = SpringContextHolder
        .getBean(ISysBonusesAO.class);

    private XN632405Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SysBonuses condition = new SysBonuses();
        condition.setIsSelfDevelop(req.getIsSelfDevelop());
        condition
            .setRetainMonths(StringValidater.toInteger(req.getRetainMonths()));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISysBonusesAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysBonusesAO.querySysBonusesPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632405Req.class);
        ObjValidater.validateReq(req);
    }

}
