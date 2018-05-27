package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IProvinceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632021Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除省份编号
 * @author: silver 
 * @since: 2018年5月27日 上午11:32:09 
 * @history:
 */
public class XN632021 extends AProcessor {

    private IProvinceAO provinceAO = SpringContextHolder
        .getBean(IProvinceAO.class);

    private XN632021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return provinceAO.dropProvince(StringValidater.toInteger(req.getId()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632021Req.class);
        ObjValidater.validateReq(req);
    }

}
