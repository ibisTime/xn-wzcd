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
 * 根据角色查询节点信息
 * @author: hp 
 * @since: 2018年5月23日 下午4:35:57 
 * @history:
 */
public class XN630167 extends AProcessor {

    private IRoleNodeAO roleNodeAO = SpringContextHolder
        .getBean(IRoleNodeAO.class);

    private XN630167Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return roleNodeAO.queryNodeListByRoleCode(req.getRoleCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630167Req.class);
        ObjValidater.validateReq(req);
    }
}
