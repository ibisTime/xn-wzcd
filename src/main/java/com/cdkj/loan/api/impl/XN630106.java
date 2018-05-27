package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN630106Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询部门
 * @author: CYL 
 * @since: 2018年5月22日 下午6:00:55 
 * @history:
 */
public class XN630106 extends AProcessor {
    private IDepartmentAO departmentAO = SpringContextHolder
        .getBean(IDepartmentAO.class);

    private XN630106Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Department condition = new Department();
        condition.setParentCode(req.getParentCode());
        condition.setTypeList(req.getTypeList());
        condition.setStatus(req.getStatus());
        condition.setKeyword(req.getKeyword());

        return departmentAO.queryDepartmentList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630106Req.class);
        ObjValidater.validateReq(req);
    }
}
