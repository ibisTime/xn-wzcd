package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630050Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增用户
 * @author: CYL 
 * @since: 2018年5月10日 下午2:12:30 
 * @history:
 */
public class XN630050 extends AProcessor {

    private ISYSUserAO userAO = SpringContextHolder.getBean(ISYSUserAO.class);

    private XN630050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(userAO.doAddUser(req.getType(),
            req.getLoginName(), req.getLoginPwd(), req.getMobile(),
            req.getRealName(), req.getRoleCode(), req.getPostCode()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630050Req.class);
        ObjValidater.validateReq(req);

    }

}
