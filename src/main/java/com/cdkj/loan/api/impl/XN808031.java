package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IProductSpecsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN808031Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除产品型号
 * @author: myb858 
 * @since: 2017年3月25日 下午3:45:18 
 * @history:
 */
public class XN808031 extends AProcessor {

    private IProductSpecsAO productSpecsAO = SpringContextHolder
        .getBean(IProductSpecsAO.class);

    private XN808031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        productSpecsAO.dropProductSpecs(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808031Req.class);
        ObjValidater.validateReq(req);
    }

}
