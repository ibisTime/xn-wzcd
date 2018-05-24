package com.cdkj.loan.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.loan.ao.IRoleNodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630160Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 角色批量设置节点
 * @author: hp 
 * @since: 2018年5月23日 下午3:32:10 
 * @history:
 */
public class XN630160 extends AProcessor {

    private IRoleNodeAO roleNodeAO = SpringContextHolder
        .getBean(IRoleNodeAO.class);

    private XN630160Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        roleNodeAO.assignNodeForRole(req.getRoleCode(), req.getNodeList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630160Req.class);
        ObjValidater.validateReq(req);
        if (CollectionUtils.isEmpty(req.getNodeList())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "节点列表不能为空");
        }
    }
}
