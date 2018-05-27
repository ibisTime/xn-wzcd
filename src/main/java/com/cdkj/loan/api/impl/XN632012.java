package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632012Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改身份证区域
 * @author: silver 
 * @since: 2018年5月27日 上午11:32:09 
 * @history:
 */
public class XN632012 extends AProcessor {

    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN632012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return areaAO.editArea(StringValidater.toInteger(req.getId()),
            req.getAreaNo(), req.getAreaName());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632012Req.class);
        ObjValidater.validateReq(req);
    }

}
