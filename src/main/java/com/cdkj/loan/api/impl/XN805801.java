package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICNavigateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805801Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 删除导航
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN805801 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805801Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        cNavigateAO.dropCNavigate(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805801Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
