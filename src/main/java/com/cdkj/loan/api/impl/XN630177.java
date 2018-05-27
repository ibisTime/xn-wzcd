package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN630177Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询日志
 * @author: CYL 
 * @since: 2018年5月24日 下午5:29:28 
 * @history:
 */
public class XN630177 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN630177Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysBizLogAO.getSYSBizLog(StringValidater.toInteger(req.getId()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630177Req.class);
        ObjValidater.validateReq(req);
    }

}
