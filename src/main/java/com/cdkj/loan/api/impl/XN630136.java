package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISaleUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.SaleUser;
import com.cdkj.loan.dto.req.XN630136Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查用户
 * @author: nyc 
 * @since: 2018年4月24日 上午11:30:04 
 * @history:
 */
public class XN630136 extends AProcessor {

    private ISaleUserAO userAO = SpringContextHolder.getBean(ISaleUserAO.class);

    private XN630136Req req = null;

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
        return userAO.querySaleUserList(condition);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630136Req.class);
    }

}
