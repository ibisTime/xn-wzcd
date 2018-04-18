package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserSettingsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.UserSettings;
import com.cdkj.loan.dto.req.XN625301Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十二月/05.
 */
public class XN625301 extends AProcessor {

    private IUserSettingsAO userSettingsAO = SpringContextHolder
            .getBean(IUserSettingsAO.class);

    private XN625301Req req;

    @Override
    public Object doBusiness() throws BizException {

        UserSettings conditoin = new UserSettings();
        conditoin.setUserId(req.getUserId());
        conditoin.setType(req.getType());
        return  this.userSettingsAO.queryUserSettingsList(conditoin);

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625301Req.class);
        ObjValidater.validateReq(req);

    }
}
