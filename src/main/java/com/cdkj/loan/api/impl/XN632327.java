package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IReplaceRepayApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.dto.req.XN632327Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 代偿预算单列表查
 * @author: silver 
 * @since: 2018年6月15日 上午11:16:11 
 * @history:
 */
public class XN632327 extends AProcessor {

    private IReplaceRepayApplyAO replaceRepayApplyAO = SpringContextHolder
        .getBean(IReplaceRepayApplyAO.class);

    private XN632327Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ReplaceRepayApply condition = new ReplaceRepayApply();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setBizCode(req.getBizCode());
        condition.setType(req.getType());
        condition.setReceiptRealName(req.getReceiptRealName());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndADatetime(),
            DateUtil.DATA_TIME_PATTERN_1));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IReplaceRepayApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return replaceRepayApplyAO.queryReplaceRepayApplyList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632327Req.class);
        ObjValidater.validateReq(req);
    }
}
