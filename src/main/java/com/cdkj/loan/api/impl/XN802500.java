package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAccountAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Account;
import com.cdkj.loan.dto.req.XN802500Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询账户
 * @author: xieyj 
 * @since: 2016年12月23日 下午8:19:09 
 * @history:
 */
public class XN802500 extends AProcessor {
    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802500Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {
        Account condition = new Account();
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setCurrency(req.getCurrency());
        condition.setLastOrder(req.getLastOrder());
        condition.setCreateDatetimeStart(
            DateUtil.getFrontDate(req.getDateStart(), false));
        condition.setCreateDatetimeEnd(
            DateUtil.getFrontDate(req.getDateEnd(), true));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IAccountAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return accountAO.queryAccountPage(start, limit, condition);
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802500Req.class);
        ObjValidater.validateReq(req);
    }
}
