package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSMenu;
import com.cdkj.loan.dto.req.XN805003Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 菜单-增加
 * @author: xieyj 
 * @since: 2016年5月16日 下午10:59:56 
 * @history:
 */
public class XN805003 extends AProcessor {

    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN805003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu data = new SYSMenu();
        data.setName(req.getName());
        data.setType(req.getType());
        data.setUrl(req.getUrl());
        data.setParentCode(req.getParentCode());
        data.setOrderNo(req.getOrderNo());

        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setSystemCode(req.getSystemCode());
        return new PKCodeRes(sysMenuAO.addSYSMenu(data));
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805003Req.class);
        StringValidater.validateBlank(req.getName(), req.getType(),
            req.getUrl(), req.getParentCode(), req.getOrderNo(),
            req.getUpdater(), req.getSystemCode());
    }
}
