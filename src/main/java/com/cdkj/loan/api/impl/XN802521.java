package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Jour;
import com.cdkj.loan.dto.req.XN802521Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询流水(oss)
 * @author: xieyj 
 * @since: 2016年12月26日 下午12:29:08 
 * @history:
 */
public class XN802521 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802521Req req = null;

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
            DateUtil.getFrontDate(req.getDateStart(), false));
        condition.setCreateDatetimeEnd(
            DateUtil.getFrontDate(req.getDateEnd(), true));
        condition.setWorkDate(req.getWorkDate());

        condition.setCheckUser(req.getCheckUser());
        condition.setAdjustUser(req.getAdjustUser());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return jourAO.queryJourList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802521Req.class);
        ObjValidater.validateReq(req);
    }
}
