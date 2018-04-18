package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGoogleAuthAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.dto.res.XN805070Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 获取谷歌验证秘钥
 * @author: haiqingzheng 
 * @since: 2017年12月6日 下午4:10:53 
 * @history:
 */
public class XN805070 extends AProcessor {

    private IGoogleAuthAO googleAuthAO = SpringContextHolder
        .getBean(IGoogleAuthAO.class);

    @Override
    public Object doBusiness() throws BizException {
        String secret = googleAuthAO.generateSecretKey();
        return new XN805070Res(secret);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
    }

}
