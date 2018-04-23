package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSMenuRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SYSMenuRole;
import com.cdkj.loan.dto.req.XN630025Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 菜单角色-查询菜单列表
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XN630025 extends AProcessor {
    private ISYSMenuRoleAO sysMenuRoleAO = SpringContextHolder
        .getBean(ISYSMenuRoleAO.class);

    private XN630025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenuRole data = new SYSMenuRole();
        data.setRoleCode(req.getRoleCode());
        data.setParentCode(req.getParentCode());
        data.setType(req.getType());
        return sysMenuRoleAO.querySYSMenuList(data);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630025Req.class);
        ObjValidater.validateReq(req);
    }
}
