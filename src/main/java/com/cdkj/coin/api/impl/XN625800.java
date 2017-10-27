/**
 * @Title XN623800.java 
 * @Package com.cdkj.ylq.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年8月21日 下午9:19:46 
 * @version V1.0   
 */
package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.common.PhoneUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN623800Req;
import com.cdkj.coin.dto.res.XN805041Res;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * C端注册
 * @author: haiqingzheng 
 * @since: 2017年8月21日 下午9:19:46 
 * @history:
 */
public class XN625800 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN623800Req req = null;

    /** 
     * @see com.cdkj.ylq.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        XN805041Res res = userAO
            .doRegister(req.getMobile(), req.getLoginPwd(),
                req.getUserReferee(), req.getUserRefereeKind(),
                req.getSmsCaptcha());
        return res;
    }

    /** 
     * @see com.cdkj.ylq.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623800Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getLoginPwd(),
            req.getSmsCaptcha());
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
    }

}
