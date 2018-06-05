package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Contract;
import com.cdkj.loan.dto.req.XN632837Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午10:05:34 
 * @history:
 */
public class XN632837 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632837Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Contract condition = new Contract();
        condition.setArchiveCode(req.getArchiveCode());
        condition.setContractNo(req.getContractNo());
        condition.setType(req.getType());
        return contractAO.queryContractList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632837Req.class);
    }
}
