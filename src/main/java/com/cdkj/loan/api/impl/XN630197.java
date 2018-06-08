package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBizTeamAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.dto.req.XN630197Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午3:48:31 
 * @history:
 */
public class XN630197 extends AProcessor {
    private IBizTeamAO bizTeamAO = SpringContextHolder
        .getBean(IBizTeamAO.class);

    private XN630197Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BizTeam condition = new BizTeam();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setStatus("1");
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBizTeamAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return bizTeamAO.queryBizTeamList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630197Req.class);
    }
}
