package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IChannelBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.dto.req.XN802115Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询渠道银行
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:18:19 
 * @history:
 */
public class XN802115 extends AProcessor {
    private IChannelBankAO channelBankAO = SpringContextHolder
        .getBean(IChannelBankAO.class);

    private XN802115Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        ChannelBank condition = new ChannelBank();
        condition.setBankCode(req.getBankCode());
        condition.setBankName(req.getBankName());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());
        condition.setChannelBank(req.getChannelBank());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IChannelBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return channelBankAO.queryChannelBankPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802115Req.class);
        ObjValidater.validateReq(req);
    }
}
