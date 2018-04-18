package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSConfigAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN625918Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据key获取value值
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:56:04 
 * @history:
 */
public class XN625918 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN625918Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return sysConfigAO.getSYSConfigMap(req.getType(), req.getCompanyCode(),
            req.getSystemCode());
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625918Req.class);
        StringValidater.validateBlank(req.getType(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
