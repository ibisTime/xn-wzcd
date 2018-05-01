package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN808060Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改运费_管理端
 * @author: xieyj 
 * @since: 2017年10月17日 下午1:07:39 
 * @history:
 */
public class XN808060 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808060Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long yunfei = StringValidater.toLong(req.getYunfei());
        orderAO.modifyYunfei(req.getCode(), yunfei);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808060Req.class);
        StringValidater.validateBlank(req.getCode(), req.getYunfei());
    }
}
