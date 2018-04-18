package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.ao.IUserRelationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.UserStatistics;
import com.cdkj.loan.dto.req.XN625256Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EUserReleationType;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625256Req.class);
        ObjValidater.validateReq(req);

    }
}
