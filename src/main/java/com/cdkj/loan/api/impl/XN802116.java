package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IChannelBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.dto.req.XN802116Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询渠道银行
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:18:19 
 * @history:
 */
public class XN802116 extends AProcessor {
    private IChannelBankAO channelBankAO = SpringContextHolder
        .getBean(IChannelBankAO.class);

    private XN802116Req req = null;

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
        return channelBankAO.queryChannelBankList(condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802116Req.class);
    }
}
