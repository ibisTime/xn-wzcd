package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.common.PhoneUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN805041Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 前端用户普通注册
 * @author: myb858 
 * @since: 2015年8月23日 上午11:42:00
 * @history:
 */
public class XN805041 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805041Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        return userAO.doRegister(req.getMobile(), req.getNickname(),
            req.getLoginPwd(), req.getUserReferee(), req.getUserRefereeKind(),
            req.getSmsCaptcha(), req.getKind(), req.getProvince(),
            req.getCity(), req.getArea(), req.getAddress(),
            req.getCompanyCode(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805041Req.class);
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
        ObjValidater.validateReq(req);
    }
}
