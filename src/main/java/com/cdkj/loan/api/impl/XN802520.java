package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Jour;
import com.cdkj.loan.dto.req.XN802520Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 流水分页查询(oss)
 * @author: xieyj 
 * @since: 2016年12月24日 上午7:59:19 
 * @history:
 */
public class XN802520 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802520Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        Jour condition = new Jour();

        condition.setKind(req.getKind());
        condition.setPayGroup(req.getPayGroup());
        condition.setRefNo(req.getRefNo());
        condition.setChannelType(req.getChannelType());
        condition.setChannelOrder(req.getChannelOrder());

        condition.setAccountNumber(req.getAccountNumber());
        condition.setCurrency(req.getCurrency());
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setType(req.getType());

        condition.setBizType(req.getBizType());
        condition.setStatus(req.getStatus());
        condition.setCreateDatetimeStart(
            DateUtil.getFrontDate(req.getCreateDatetimeStart(), false));
        condition.setCreateDatetimeEnd(
            DateUtil.getFrontDate(req.getCreateDatetimeEnd(), true));
        condition.setWorkDate(req.getWorkDate());

        condition.setCheckUser(req.getCheckUser());
        condition.setAdjustUser(req.getAdjustUser());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return jourAO.queryJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802520Req.class);
        ObjValidater.validateReq(req);
    }
}
