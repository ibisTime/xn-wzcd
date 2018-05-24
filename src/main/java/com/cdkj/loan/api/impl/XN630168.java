package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRoleNodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630168Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 查询所有节点列表（包含当前用户）
 * @author: jiafr 
 * @since: 2018年5月24日 上午11:48:33 
 * @history:
 */
public class XN630168 extends AProcessor {

    private IRoleNodeAO iRoleNodeAO = SpringContextHolder
        .getBean(IRoleNodeAO.class);

    private XN630168Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return iRoleNodeAO.queryNodeListIncludeCurRoleCode(req.getRoleCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630168Req.class);
        if (null == req.getRoleCode()) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "角色编号不能为空");
        }
        ObjValidater.validateReq(req);

    }
}
