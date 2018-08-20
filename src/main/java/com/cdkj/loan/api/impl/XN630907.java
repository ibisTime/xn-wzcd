package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 在保金额
 * @author: jiafr 
 * @since: 2018年8月20日 下午5:06:17 
 * @history:
 */
public class XN630907 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    @Override
    public Object doBusiness() throws BizException {
        return repayBizAO.unclearedLoanTotalAmount();
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {

    }

}
