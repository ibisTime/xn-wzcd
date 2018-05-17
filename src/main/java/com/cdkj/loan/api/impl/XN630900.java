package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.dto.res.XN630900Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 未结清贷款总额
 * @author: CYL 
 * @since: 2018年5月17日 下午10:00:15 
 * @history:
 */
public class XN630900 extends AProcessor {
    private IRepayPlanAO repayPlanAO = SpringContextHolder
        .getBean(IRepayPlanAO.class);

    @Override
    public Object doBusiness() throws BizException {
        XN630900Res res = new XN630900Res();
        Long unsettledLoan = repayPlanAO.getUnsettledLoan();
        res.setUnsettledLoan(unsettledLoan);
        return res;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
    }

}
