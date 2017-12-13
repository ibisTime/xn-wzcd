package com.cdkj.coin.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.ao.IUserRelationAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.UserRelation;
import com.cdkj.coin.dto.req.XN805115Req;
import com.cdkj.coin.enums.EUserReleationType;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
            column = IUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        condition.setType(type);
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userRelationAO.queryUserRelationPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805115Req.class);
        ObjValidater.validateReq(req);
    }
}
