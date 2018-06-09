package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.dto.req.XN632316Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询返点支付
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:29:03 
 * @history:
 */
public class XN632316 extends AProcessor {
    private IRepointAO repointAO = SpringContextHolder
        .getBean(IRepointAO.class);

    private XN632316Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return repointAO.getRepoint(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632316Req.class);
    }
}
