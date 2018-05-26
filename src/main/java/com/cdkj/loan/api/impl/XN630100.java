package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630100Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增部门
 * @author: CYL 
 * @since: 2018年5月26日 下午2:54:15 
 * @history:
 */
public class XN630100 extends AProcessor {
    private IDepartmentAO departmentAO = SpringContextHolder
        .getBean(IDepartmentAO.class);

    private XN630100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(departmentAO.addDepartment(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630100Req.class);
        ObjValidater.validateReq(req);
    }

}
