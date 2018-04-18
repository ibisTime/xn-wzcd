package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805042Req;
import com.cdkj.loan.dto.res.XN805042Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 管理端代注册
 * @author: myb858 
 * @since: 2015年11月10日 下午12:59:10 
 * @history:
 */
public class XN805042 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XN805042Res(userAO.doAddUser(req));
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805042Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getKind(),
            req.getUpdater(), req.getCompanyCode(), req.getSystemCode());
    }
}
