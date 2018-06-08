package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.dto.req.XN632835Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午9:06:46 
 * @history:
 */
public class XN632835 extends AProcessor {

    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632835Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Contract condition = new Contract();
        condition.setUserId(req.getUserId());
        condition.setContractNo(req.getContractNo());
        condition.setType(req.getType());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSRoleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return contractAO.queryContractPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632835Req.class);
        ObjValidater.validateReq(req);
    }
}
