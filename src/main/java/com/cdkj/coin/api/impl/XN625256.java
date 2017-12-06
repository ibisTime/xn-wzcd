package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.ao.IUserRelationAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.UserStatistics;
import com.cdkj.coin.dto.req.XN625256Req;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.enums.EUserReleationType;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by tianlei on 2017/十一月/23.
 */
public class XN625256 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
            .getBean(ITradeOrderAO.class);

    //
    private IUserRelationAO userRelationAO = SpringContextHolder
            .getBean(IUserRelationAO.class);

    //
    private XN625256Req req;

    @Override
    public Object doBusiness() throws BizException {

//        throw new BizException("xn000","已经弃用");
        UserStatistics userStatistics = this.tradeOrderAO.userStatisticsInfoContainTradeCount(req.getMaster());
        //
        if (StringUtils.isNotBlank(req.getVisitor())) {
            //
            boolean isTruest = this.userRelationAO.isExistUserRelation(req.getVisitor(), req.getMaster(), EUserReleationType.TRUST.getCode());

            boolean isAddBlackList = this.userRelationAO.isExistUserRelation(req.getVisitor(), req.getMaster(), EUserReleationType.BLACKLIST.getCode());

            userStatistics.setIsTrust(isTruest ? EBoolean.YES.getCode() : EBoolean.NO.getCode());
            userStatistics.setIsAddBlackList(isAddBlackList ? EBoolean.YES.getCode() : EBoolean.NO.getCode());

            //之间的交易次数
            long tradeTimesBetweenUser = this.tradeOrderAO.getTradeTimesBetweenUser(req.getMaster(), req.getVisitor());
            userStatistics.setBetweenTradeTimes(Long.valueOf(tradeTimesBetweenUser).toString());

        } else {

            userStatistics.setIsTrust(EBoolean.NO.getCode());
            userStatistics.setIsAddBlackList(EBoolean.NO.getCode());

        }

        return userStatistics;

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625256Req.class);
        ObjValidater.validateReq(req);

    }
}
