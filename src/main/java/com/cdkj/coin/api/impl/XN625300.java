package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserSettingsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625300Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十二月/05.
 */
public class XN625300 extends AProcessor {


    private IUserSettingsAO userSettingsAO = SpringContextHolder
            .getBean(IUserSettingsAO.class);

    private XN625300Req req;

    @Override
    public Object doBusiness() throws BizException {

        if (req.getOpType().equals("0")) {
            //设置

            this.userSettingsAO.addUserSettings(req.getUserId(),req.getType());

        } else if (req.getOpType().equals("1")) {
            //删除设置
            this.userSettingsAO.dropUserSettings(req.getUserId(),req.getType());

        } else {

            throw new  BizException("xn000","不支持的操作类型");

        }

        //
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625300Req.class);
        ObjValidater.validateReq(req);
    }
}
