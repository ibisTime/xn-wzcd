package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805004Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 菜单-删除
 * @author: xieyj 
 * @since: 2016年5月16日 下午11:00:43 
 * @history:
 */
public class XN805004 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN805004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(sysMenuAO.dropSYSMenu(req.getCode()));
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805004Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
