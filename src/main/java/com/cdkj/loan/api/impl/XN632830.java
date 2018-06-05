package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.dto.req.XN632830Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:26:14 
 * @history:
 */
public class XN632830 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632830Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Contract data = new Contract();
        data.setArchiveCode(req.getArchiveCode());
        data.setContractNo(req.getContractNo());
        data.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setType(req.getType());
        data.setPdf(req.getPdf());
        data.setRemark(req.getRemark());
        return new PKCodeRes(contractAO.addContract(data));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632830Req.class);
        ObjValidater.validateReq(req);
    }

}
