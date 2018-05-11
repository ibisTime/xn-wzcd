package com.cdkj.loan.api.impl;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.QnTokenImpl;
import com.cdkj.loan.dto.res.XN630091Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据系统编号获取七牛uploadToken
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:45:51 
 * @history:
 */
public class XN630091 extends AProcessor {
    private QnTokenImpl qnTokenImpl = SpringContextHolder
        .getBean(QnTokenImpl.class);

    @Override
    public Object doBusiness() throws BizException {
        return new XN630091Res(qnTokenImpl.getUploadToken());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
    }
}
