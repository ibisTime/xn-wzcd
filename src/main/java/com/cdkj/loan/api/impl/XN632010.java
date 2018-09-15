package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632010Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:32:09 
 * @history:
 */
public class XN632010 extends AProcessor {

    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN632010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        areaAO.addArea(req.getAreaNo(), req.getAreaName());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632010Req.class);
        ObjValidater.validateReq(req);
    }
}
