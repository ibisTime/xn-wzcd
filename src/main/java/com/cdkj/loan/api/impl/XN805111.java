package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IUserRelationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805111Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.enums.EUserReleationType;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 解除关注关系
 * @author: xieyj 
 * @since: 2016年8月31日 上午9:26:10 
 * @history:
 */
public class XN805111 extends AProcessor {
    private IUserRelationAO userRelationAO = SpringContextHolder
        .getBean(IUserRelationAO.class);

    private XN805111Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        String type = req.getType();
        if (StringUtils.isBlank(type)) {
            type = EUserReleationType.TRUST.getCode();
        }

        userRelationAO.unfollowUser(req.getUserId(), req.getToUser(),type);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805111Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getToUser());
    }
}
