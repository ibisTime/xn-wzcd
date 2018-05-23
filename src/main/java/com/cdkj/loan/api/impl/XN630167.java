package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRoleNodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630167Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 角色批量设置节点
 * @author: hp 
 * @since: 2018年5月23日 下午3:32:10 
 * @history:
 */
public class XN630167 extends AProcessor {

    private IRoleNodeAO roleNodeAO = SpringContextHolder
        .getBean(IRoleNodeAO.class);

    private XN630167Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return roleNodeAO.queryNodeRoleListByRoleCode(req.getRoleCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630167Req.class);
        ObjValidater.validateReq(req);
    }
}
