package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IChannelBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.dto.req.XN802112Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改渠道银行
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:18:19 
 * @history:
 */
public class XN802112 extends AProcessor {
    private IChannelBankAO channelBankAO = SpringContextHolder
        .getBean(IChannelBankAO.class);

    private XN802112Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        ChannelBank data = new ChannelBank();
        data.setId(StringValidater.toLong(req.getId()));
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setChannelType(req.getChannelType());
        data.setStatus(req.getStatus());
        data.setChannelBank(req.getChannelBank());
        data.setMaxOrder(StringValidater.toLong(req.getMaxOrder()));
        data.setOrderAmount(StringValidater.toLong(req.getOrderAmount()));
        data.setDayAmount(StringValidater.toLong(req.getDayAmount()));
        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setRemark(req.getRemark());
        channelBankAO.editChannelBank(data);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802112Req.class);
        ObjValidater.validateReq(req);
    }
}
