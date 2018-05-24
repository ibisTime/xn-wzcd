package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN630175Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询日志
 * @author: CYL 
 * @since: 2018年5月24日 下午5:29:28 
 * @history:
 */
public class XN630175 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN630175Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSBizLog condition = new SYSBizLog();
        condition.setParentOrder(req.getParentOrder());
        condition.setRefType(req.getRefType());
        condition.setRefOrder(req.getRefOrder());
        condition.setStatus(req.getStatus());
        condition.setOperateRole(req.getOperateRole());
        condition.setOperator(req.getOperator());
        condition.setOperatorName(req.getOperatorName());
        condition.setOperatorMobile(req.getOperatorMobile());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setStartDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSBizLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysBizLogAO.querySYSBizLogPage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630175Req.class);
        ObjValidater.validateReq(req);
    }

}
