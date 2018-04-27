package com.cdkj.loan.api.impl;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.QnTokenImpl;
import com.cdkj.loan.dto.res.XN805951Res;
import com.cdkj.loan.enums.ESystemCode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 上传图片
 * @author: nyc 
 * @since: 2018年4月25日 上午10:52:10 
 * @history:
 */
public class XN630081 extends AProcessor {
    private QnTokenImpl qnTokenImpl = SpringContextHolder
        .getBean(QnTokenImpl.class);

    @Override
    public Object doBusiness() throws BizException {
        return new XN805951Res(qnTokenImpl.getUploadToken(
            ESystemCode.HTWT.getCode(), ESystemCode.HTWT.getCode()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {

    }
}
