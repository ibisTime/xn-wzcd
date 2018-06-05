package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IConvertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632876Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查
 * @author: CYL 
 * @since: 2018年6月5日 下午9:50:31 
 * @history:
 */
public class XN632876 extends AProcessor {
    private IConvertApplyAO convertApplyAO = SpringContextHolder
        .getBean(IConvertApplyAO.class);

    private XN632876Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return convertApplyAO.getConvertApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632876Req.class);
        ObjValidater.validateReq(req);
    }

}
