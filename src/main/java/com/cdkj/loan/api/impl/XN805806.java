package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICNavigateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CNavigate;
import com.cdkj.loan.dto.req.XN805806Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 前端查询导航
 * @author: xieyj 
 * @since: 2016年10月25日 下午4:51:09 
 * @history:
 */
public class XN805806 extends AProcessor {
    private ICNavigateAO cNavigateAO = SpringContextHolder
        .getBean(ICNavigateAO.class);

    private XN805806Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CNavigate condition = new CNavigate();
        condition.setType(req.getType());
        condition.setParentCode(req.getParentCode());
        condition.setLocation(req.getLocation());
        condition.setStatus(EBoolean.YES.getCode());
        condition.setIsFront(EBoolean.YES.getCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        return cNavigateAO.queryCNavigateList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805806Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }
}
