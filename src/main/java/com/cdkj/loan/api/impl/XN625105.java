/**
 * @Title XN625100.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月9日 下午7:00:49 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEthCollectionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.EthCollection;
import com.cdkj.loan.dto.req.XN625105Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 分页查询归集订单
 * @author: haiqingzheng 
 * @since: 2017年11月9日 下午7:00:49 
 * @history:
 */
public class XN625105 extends AProcessor {

    private IEthCollectionAO ethCollectionAO = SpringContextHolder
        .getBean(IEthCollectionAO.class);

    private XN625105Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        EthCollection condition = new EthCollection();
        condition.setCodeForQuery(req.getCode());
        condition.setFromAddress(req.getFromAddress());
        condition.setToAddress(req.getToAddress());
        condition.setStatus(req.getStatus());
        condition.setTxHash(req.getTxHash());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return ethCollectionAO.queryEthCollectionPage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625105Req.class);
        ObjValidater.validateReq(req);
    }

}
