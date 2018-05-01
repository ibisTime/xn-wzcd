package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IProductSpecsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808037Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询产品型号
 * @author: myb858 
 * @since: 2017年3月25日 下午3:50:33 
 * @history:
 */
public class XN808037 extends AProcessor {

    private IProductSpecsAO productSpecsAO = SpringContextHolder
        .getBean(IProductSpecsAO.class);

    private XN808037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ProductSpecs condition = new ProductSpecs();
        condition.setProductCode(req.getProductCode());
        return productSpecsAO.queryProductSpecsList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808037Req.class);
        ObjValidater.validateReq(req);
    }

}
