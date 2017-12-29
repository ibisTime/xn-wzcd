package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserSettingsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.UserSettings;
import com.cdkj.coin.dto.req.XN625301Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
