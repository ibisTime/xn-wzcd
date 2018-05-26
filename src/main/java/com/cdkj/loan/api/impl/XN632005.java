package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632005Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询收款账号
 * @author: CYL 
 * @since: 2018年5月25日 下午4:55:45 
 * @history:
 */
public class XN632005 extends AProcessor {
    private ICollectBankcardAO collectBankcardAO = SpringContextHolder
        .getBean(ICollectBankcardAO.class);

    private XN632005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CollectBankcard condition = new CollectBankcard();
        condition.setType(req.getType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setKeyword(req.getKeyword());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICollectBankcardAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return collectBankcardAO.queryCollectBankcardPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632005Req.class);
        ObjValidater.validateReq(req);
    }

}
