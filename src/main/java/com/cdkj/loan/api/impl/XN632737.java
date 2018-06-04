package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRegimeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Regime;
import com.cdkj.loan.dto.req.XN632737Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询公司制度
 * @author: silver 
 * @since: 2018年6月4日 下午8:54:52 
 * @history:
 */
public class XN632737 extends AProcessor {

    private IRegimeAO regimeAO = SpringContextHolder.getBean(IRegimeAO.class);

    private XN632737Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Regime condition = new Regime();
        condition.setType(req.getType());
        condition.setRegimeCode(req.getRegimeCode());
        condition.setName(req.getName());
        return regimeAO.queryRegimeList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632737Req.class);
        ObjValidater.validateReq(req);
    }

}
