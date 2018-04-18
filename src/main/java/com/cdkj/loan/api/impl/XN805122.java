package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN805122Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 推荐人查询用户列表
 * @author: xieyj 
 * @since: 2016年12月15日 下午9:00:02 
 * @history:
 */
public class XN805122 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805122Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return userAO.getUserRefereeList(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805122Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
