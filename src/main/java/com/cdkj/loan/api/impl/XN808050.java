package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN808050Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 立即下单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808050 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808050Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return orderAO.commitOrder(req);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808050Req.class);
        if (null == req.getPojo()) {
            throw new BizException("xn702000", "订单基本信息不能为空");
        }
        if (StringUtils.isBlank(req.getToUser())) {
            StringValidater.validateBlank(req.getPojo().getReceiver(),
                req.getPojo().getReMobile(), req.getPojo().getReAddress());
        }
        StringValidater.validateBlank(req.getProductSpecsCode(),
            req.getQuantity(), req.getPojo().getApplyUser());
        StringValidater.validateNumber(req.getQuantity());
    }
}
