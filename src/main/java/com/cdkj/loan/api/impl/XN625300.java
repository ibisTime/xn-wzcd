package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserSettingsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625300Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
            this.userSettingsAO.addUserSettings(req.getUserId(), req.getType());

        } else if (req.getOpType().equals("1")) {
            //删除设置
            this.userSettingsAO.dropUserSettings(req.getUserId(), req.getType());

        } else {

            throw new BizException("xn000", "不支持的操作类型");

        }

        //
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625300Req.class);
        ObjValidater.validateReq(req);
    }
}
