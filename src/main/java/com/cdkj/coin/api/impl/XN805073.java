package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN805073Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 修改支付密码
 * @author: myb858 
 * @since: 2015年9月15日 下午2:30:11 
 * @history:
 */
public class XN805073 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805073Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.addUserReferee(req.getUserId(), req.getUserReferee(),
            req.getUserRefereeKind());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805073Req.class);
        ObjValidater.validateReq(req);
    }

}
