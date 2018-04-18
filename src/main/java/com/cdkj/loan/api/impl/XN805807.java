package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICNavigateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805807Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 详情查询导航
 * @author: zuixian 
 * @since: 2016年10月10日 下午3:58:13 
 * @history:
 */
public class XN805807 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805807Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return cNavigateAO.getCNavigate(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805807Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
