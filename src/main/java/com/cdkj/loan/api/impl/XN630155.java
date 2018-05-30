package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.INodeFlowAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.dto.req.XN630155Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询节点流程
 * @author: CYL 
 * @since: 2018年5月23日 下午9:25:37 
 * @history:
 */
public class XN630155 extends AProcessor {
    private INodeFlowAO nodeFlowAO = SpringContextHolder
        .getBean(INodeFlowAO.class);

    private XN630155Req req = null;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        NodeFlow condition = new NodeFlow();
        condition.setType(req.getType());
        condition.setCurrentNode(req.getCurrentNode());
        condition.setNextNode(req.getNextNode());
        condition.setBackNode(req.getBackNode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INodeFlowAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, "asc");
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return nodeFlowAO.queryNodeFlowPage(start, limit, condition);
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
