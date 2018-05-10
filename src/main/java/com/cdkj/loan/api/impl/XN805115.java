package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.ao.IUserRelationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.UserRelation;
import com.cdkj.loan.dto.req.XN805115Req;
import com.cdkj.loan.enums.EUserReleationType;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询关注人
 *
 * @author: xieyj
 * @since: 2016年8月31日 下午12:44:27
 * @history:
 */
public class XN805115 extends AProcessor {
    private IUserRelationAO userRelationAO = SpringContextHolder
        .getBean(IUserRelationAO.class);

    private XN805115Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        UserRelation condition = new UserRelation();
        condition.setUserId(req.getUserId());
        condition.setToUser(req.getToUser());

        String type = req.getType();
        if (StringUtils.isBlank(type)) {

            type = EUserReleationType.TRUST.getCode();

        }

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        condition.setType(type);
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userRelationAO.queryUserRelationPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805115Req.class);
        ObjValidater.validateReq(req);
    }
}
