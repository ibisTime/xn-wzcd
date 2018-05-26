package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630102Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改部门
 * @author: CYL 
 * @since: 2018年5月26日 下午2:54:24 
 * @history:
 */
public class XN630102 extends AProcessor {
    private IDepartmentAO departmentAO = SpringContextHolder
        .getBean(IDepartmentAO.class);

    private XN630102Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        departmentAO.editDepartment(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630102Req.class);
        ObjValidater.validateReq(req);
    }

}
