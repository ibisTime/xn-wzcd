package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630065Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查用户
 * @author: nyc 
 * @since: 2018年4月24日 上午11:30:04 
 * @history:
 */
public class XN630065 extends AProcessor {

    private ISYSUserAO userAO = SpringContextHolder.getBean(ISYSUserAO.class);

    private XN630065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser condition = new SYSUser();
        condition.setKeyword(req.getKeyword());
        condition.setCreateDatetimeStart(
            DateUtil.getFrontDate(req.getCreateDatetimeStart(), false));
        condition.setCreateDatetimeEnd(
            DateUtil.getFrontDate(req.getCreateDatetimeEnd(), true));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userAO.queryUserPage(start, limit, condition);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630065Req.class);
        ObjValidater.validateReq(req);
    }

}
