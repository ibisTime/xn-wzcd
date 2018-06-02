package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.dto.req.XN632307Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询逾期客户
 * @author: CYL 
 * @since: 2018年6月2日 下午11:10:22 
 * @history:
 */
public class XN632307 extends AProcessor {
    private IOverdueMenuAO overdueMenuAO = SpringContextHolder
        .getBean(IOverdueMenuAO.class);

    private XN632307Req req = null;

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

        return overdueMenuAO.queryOverdueMenuList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632307Req.class);
        ObjValidater.validateReq(req);
    }

}
