package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.domain.UserStatistics;
import com.cdkj.coin.dto.req.XN805121Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 根据userId获取用户信息
 *
 * @author: myb858
 * @since: 2015年8月23日 下午1:48:57
 * @history:
 */
public class XN805121 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private ITradeOrderAO tradeOrderAO = SpringContextHolder.getBean(ITradeOrderAO.class);

    private XN805121Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        User user = userAO.doGetUser(req.getUserId());
        UserStatistics userStatistics = tradeOrderAO.userStatisticsInfoContainTradeCount(user.getUserId());
        user.setUserStatistics(userStatistics);
        return user;

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805121Req.class);
        StringValidater.validateBlank(req.getUserId());
    }

}
