package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805022Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 角色-详情
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XN805022 extends AProcessor {
    private ISYSRoleAO sysRoleAO = SpringContextHolder
        .getBean(ISYSRoleAO.class);

    private XN805022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysRoleAO.getSYSRole(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805022Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
