package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN630176Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询日志
 * @author: CYL 
 * @since: 2018年5月24日 下午5:29:28 
 * @history:
 */
public class XN630176 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN630176Req req = null;

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

        return sysBizLogAO.querySYSBizLogList(condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630176Req.class);
        ObjValidater.validateReq(req);
    }

}
