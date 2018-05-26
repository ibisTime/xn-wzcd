package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SaleUser;
import com.cdkj.loan.dto.req.XN630135Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查业务员
 * @author: CYL 
 * @since: 2018年5月26日 上午11:13:32 
 * @history:
 */
public class XN630135 extends AProcessor {

    private ISaleUserAO userAO = SpringContextHolder.getBean(ISaleUserAO.class);

    private XN630135Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SaleUser condition = new SaleUser();
        condition.setKeyword(req.getKeyword());
        condition.setCreateDatetimeStart(
            DateUtil.getFrontDate(req.getCreateDatetimeStart(), false));
        condition.setCreateDatetimeEnd(
            DateUtil.getFrontDate(req.getCreateDatetimeEnd(), true));
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setRoleCode(req.getRoleCode());
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setUpdater(req.getUpdater());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISaleUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userAO.querySaleUserPage(start, limit, condition);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630135Req.class);
        ObjValidater.validateReq(req);
    }

}
