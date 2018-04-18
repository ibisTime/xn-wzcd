/**
 * @Title XN625100.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月9日 下午7:00:49 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEthTransactionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.EthTransaction;
import com.cdkj.loan.dto.req.XN625207Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 分页查询广播记录
 * @author: haiqingzheng 
 * @since: 2017年11月9日 下午7:00:49 
 * @history:
 */
public class XN625207 extends AProcessor {

    private IEthTransactionAO ethTransactionAO = SpringContextHolder
        .getBean(IEthTransactionAO.class);

    private XN625207Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        EthTransaction condition = new EthTransaction();
        condition.setHash(req.getHash());
        condition.setBlockHash(req.getBlockHash());
        condition.setBlockNumber(req.getBlockNumber());
        condition.setFrom(req.getFrom());
        condition.setTo(req.getTo());
        condition.setRefNo(req.getRefNo());
        condition.setCreatesStart(req.getDateStart());
        condition.setCreatesEnd(req.getDateEnd());
        condition.setAddress(req.getAddress());
        condition.setOrder("creates", "desc");
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return ethTransactionAO
            .queryEthTransactionPage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625207Req.class);
        ObjValidater.validateReq(req);
    }

}
