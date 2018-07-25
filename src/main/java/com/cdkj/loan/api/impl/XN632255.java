package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IContractImportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ContractImport;
import com.cdkj.loan.dto.req.XN632255Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行合同导入分页查
 * @author: CYL 
 * @since: 2018年7月25日 上午10:29:41 
 * @history:
 */
public class XN632255 extends AProcessor {
    private IContractImportAO contractImportAO = SpringContextHolder
        .getBean(IContractImportAO.class);

    private XN632255Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ContractImport condition = new ContractImport();
        condition.setContractCode(req.getContractCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setBankCode(req.getBankCode());
        condition.setImportDatetime(DateUtil.strToDate(req.getImportDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setStatus(req.getStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IContractImportAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return contractImportAO.queryContractImportPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632255Req.class);
        ObjValidater.validateReq(req);
    }

}
