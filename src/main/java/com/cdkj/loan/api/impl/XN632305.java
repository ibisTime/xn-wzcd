package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.dto.req.XN632305Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询逾期客户
 * @author: CYL 
 * @since: 2018年6月2日 下午11:09:54 
 * @history:
 */
public class XN632305 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632305Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        OverdueMenu condition = new OverdueMenu();
        condition.setBudgetOrderCode(req.getBudgetOrderCode());
        condition.setRealName(req.getRealName());
        condition.setAdvanceFundDatetimeStart(
            DateUtil.strToDate(req.getAdvanceFundDatetimeStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setAdvanceFundDatetimeEnd(
            DateUtil.strToDate(req.getAdvanceFundDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return overdueMenuAO.queryOverdueMenuPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632305Req.class);
        ObjValidater.validateReq(req);
    }

}
