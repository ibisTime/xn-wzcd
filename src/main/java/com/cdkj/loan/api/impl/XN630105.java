package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.dto.req.XN630105Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询
 * @author: CYL 
 * @since: 2018年5月22日 下午6:00:55 
 * @history:
 */
public class XN630105 extends AProcessor {
    private IDepartmentAO departmentAO = SpringContextHolder
        .getBean(IDepartmentAO.class);

    private XN630105Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Department condition = new Department();
        condition.setParentCode(req.getParentCode());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setKeyword(req.getKeyword());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return departmentAO.queryDepartmentPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630105Req.class);
        ObjValidater.validateReq(req);
    }
}
