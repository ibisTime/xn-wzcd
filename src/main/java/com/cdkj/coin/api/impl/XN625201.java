/**
 * @Title XN625200.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月8日 下午3:12:21 
 * @version V1.0   
 */
package com.cdkj.coin.api.impl;

import java.util.Date;

import com.cdkj.coin.ao.IEthAddressAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.DateUtil;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.dto.req.XN625201Req;
import com.cdkj.coin.dto.req.XN625201ReqList;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 导入归集地址（无私钥）
 * @author: haiqingzheng 
 * @since: 2017年11月8日 下午3:12:21 
 * @history:
 */
public class XN625201 extends AProcessor {

    private IEthAddressAO ethAddressAO = SpringContextHolder
        .getBean(IEthAddressAO.class);

    private XN625201ReqList req = null;

    /** 
     * @see com.cdkj.coin.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        for (XN625201Req req : req.getwAddressList()) {
            Date start = DateUtil.strToDate(req.getAvailableDatetimeStart(),
                DateUtil.DATA_TIME_PATTERN_1);
            Date end = DateUtil.strToDate(req.getAvailableDatetimeEnd(),
                DateUtil.DATA_TIME_PATTERN_1);
            ethAddressAO.importWAddress(req.getAddress(), start, end);
        }

        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.coin.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625201ReqList.class);
    }

}
