package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.domain.UserStatistics;
import com.cdkj.loan.dto.req.XN805121Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据userId获取用户信息
 *
 * @author: myb858
 * @since: 2015年8月23日 下午1:48:57
 * @history:
 */
public class XN805121 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private XN805121Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        User user = userAO.doGetUser(req.getUserId());
        UserStatistics userStatistics = tradeOrderAO
            .userStatisticsInfoContainTradeCount(user.getUserId());
        user.setUserStatistics(userStatistics);
        return user;

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805121Req.class);
        ObjValidater.validateReq(req);
    }

}
