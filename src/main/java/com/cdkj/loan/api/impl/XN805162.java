package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Address;
import com.cdkj.loan.dto.req.XN805162Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 收件地址 修改
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN805162 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN805162Req req = null;

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Address data = new Address();
        data.setCode(req.getCode());
        data.setAddressee(req.getAddressee());
        data.setMobile(req.getMobile());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());
        data.setDetail(req.getDetail());
        data.setIsDefault(req.getIsDefault());
        int count = addressAO.editAddress(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805162Req.class);
        ObjValidater.validateReq(req);
    }
}
