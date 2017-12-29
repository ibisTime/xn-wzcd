package com.cdkj.coin.api.impl;

import java.math.BigDecimal;

import com.cdkj.coin.ao.IJourAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN802800Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 人工对账
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:48:54 
 * @history:
 */
public class XN802800 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802800Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        BigDecimal checkAmount = StringValidater.toBigDecimal(req
            .getCheckAmount());
        jourAO.checkJour(req.getCode(), checkAmount, req.getCheckUser(),
            req.getCheckNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802800Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckNote(),
            req.getCheckUser(), req.getSystemCode());
        StringValidater.validateAmount(req.getCheckAmount());
    }
}
