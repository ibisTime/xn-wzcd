package com.cdkj.coin.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.coin.ao.ISYSMenuRoleAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.SYSMenuRole;
import com.cdkj.coin.dto.req.XN805027Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 菜单角色-增加菜单角色
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XN805027 extends AProcessor {
    private ISYSMenuRoleAO sysMenuRoleAO = SpringContextHolder
        .getBean(ISYSMenuRoleAO.class);

    private XN805027Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenuRole data = new SYSMenuRole();
        data.setRoleCode(req.getRoleCode());
        data.setMenuCodeList(req.getMenuCodeList());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setSystemCode(req.getSystemCode());
        sysMenuRoleAO.addSYSMenuRole(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805027Req.class);
        StringValidater.validateBlank(req.getRoleCode(), req.getUpdater(),
            req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getMenuCodeList())) {
            throw new BizException("xnlh4000", "菜单列表不能为空");
        }
    }
}
