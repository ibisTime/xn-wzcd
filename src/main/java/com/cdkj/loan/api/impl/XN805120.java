package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN805120Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询用户列表
 * @author: xieyj 
 * @since: 2017年7月16日 下午4:38:56 
 * @history:
 */
public class XN805120 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805120Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        User condition = new User();

        condition.setLoginName(req.getLoginName());
        condition.setMobileForQuery(req.getMobile());
        condition.setNicknameForQuery(req.getNickname());
        condition.setKind(req.getKind());
        condition.setIdKind(req.getIdKind());

        condition.setIdNo(req.getIdNo());
        condition.setRealNameForQuery(req.getRealName());
        condition.setStatus(req.getStatus());
        condition.setSign(req.getSign());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getCreateDatetimeStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(
            req.getCreateDatetimeEnd(), true));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return userAO.queryUserPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805120Req.class);
        ObjValidater.validateReq(req);
    }
}
