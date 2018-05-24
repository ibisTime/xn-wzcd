package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.INodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.dto.req.XN630155Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询流程节点
 * @author: CYL 
 * @since: 2018年5月23日 下午9:25:37 
 * @history:
 */
public class XN630155 extends AProcessor {
    private INodeAO nodeAO = SpringContextHolder.getBean(INodeAO.class);

    private XN630155Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Node condition = new Node();
        condition.setNameQuery(req.getName());
        condition.setType(req.getType());
        condition.setNextNode(req.getNextNode());
        condition.setBackNode(req.getBackNode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INodeAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return nodeAO.queryNodePage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630155Req.class);
        ObjValidater.validateReq(req);
    }

}
