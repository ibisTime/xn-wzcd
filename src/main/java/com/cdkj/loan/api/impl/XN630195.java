package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.dto.req.XN630195Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:30:54 
 * @history:
 */
public class XN630195 extends AProcessor {

    private IBizTeamAO bizTeamAO = SpringContextHolder
        .getBean(IBizTeamAO.class);

    private XN630195Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BizTeam condition = new BizTeam();
        condition.setCompanyCode(req.getCompanyCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSRoleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bizTeamAO.queryBizTeamPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630195Req.class);
        ObjValidater.validateReq(req);
    }
}
