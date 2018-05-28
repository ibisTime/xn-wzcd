/**
 * @Title XNlh5013.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午7:40:47 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.dto.req.XN630147Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询流程节点
 * @author: CYL 
 * @since: 2018年5月23日 下午9:25:37 
 * @history:
 */
public class XN630147 extends AProcessor {
    private INodeAO nodeAO = SpringContextHolder.getBean(INodeAO.class);

    private XN630147Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Node condition = new Node();
        condition.setNameQuery(req.getName());
        condition.setType(req.getType());

        return nodeAO.queryNodeList(condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630147Req.class);
        ObjValidater.validateReq(req);
    }

}
